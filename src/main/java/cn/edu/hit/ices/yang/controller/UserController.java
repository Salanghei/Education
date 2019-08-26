package cn.edu.hit.ices.yang.controller;

import cn.edu.hit.ices.yang.model.*;
import cn.edu.hit.ices.yang.service.FriendService;
import cn.edu.hit.ices.yang.service.ResourceService;
import cn.edu.hit.ices.yang.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private FriendService friendService;

    @Resource
    private ResourceService resourceService;

    @RequestMapping(path = "/login", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpServletRequest request){
        User user = userService.getUserByUsername(email);
        String message, userInfoMes;
        Map<String, Object> map = new HashMap<>();
        if(user != null){
            // 用户存在，判断密码是否正确
            if(user.getPassword().equals(password)){
                if(request.getSession().getAttribute("user") != null){
                    request.getSession().removeAttribute("user");
                }
                message = "success";
                request.getSession().setAttribute("user", user);  // 设置Session
                StudentInfo studentInfo = userService.getUserInfoById(user.getUserid()).get(0);  // 获取用户信息
                if(studentInfo != null){
                    userInfoMes = "success";
                }else{
                    userInfoMes = "fail";
                }
                map.put("userInfoMes", userInfoMes);
                map.put("studentInfo", studentInfo);
            }else{
                message = "wrongPassword";
            }
        }else{
            message = "userDoesNotExist";
        }
        map.put("message", message);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 模拟信任关系网络，并显示到社交界面
    @RequestMapping(path = "/trustNetworkData", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String trustNetworkData(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        JSONObject result = new JSONObject();
        List<Integer> studentLst = userService.getRandomStudentID(40);
        JSONArray nodes = new JSONArray();
        JSONArray edges = new JSONArray();
        int level1 = 5;   // 第一层节点
        Random r = new Random();
        int level2 = r.nextInt(5) + 15;  // 第二层节点

        JSONObject firstNode = new JSONObject();  // 中心节点为已登录的用户
        firstNode.put("category", 0);
        firstNode.put("name", String.valueOf(user.getUserid()));
        firstNode.put("value", 40);
        nodes.add(firstNode);    // 将中心节点加入

        List<Integer> recommendIds = new ArrayList<>();
        List<Double> weights = new ArrayList<>();

        for(int i  = 0; i < level1; i ++){  // 第一层节点
            JSONObject node = new JSONObject();  // 创建新节点
            node.put("category", 1);
            node.put("name", String.valueOf(studentLst.get(i)));
            node.put("value", 30);
            nodes.add(node);
            recommendIds.add(studentLst.get(i));
            JSONObject edge = new JSONObject();  // 创建新边
            edge.put("source", String.valueOf(user.getUserid()));   // 第一层每个节点都与中心节点相连
            edge.put("target", String.valueOf(studentLst.get(i)));
            Double weight = r.nextDouble() * 0.3 + 0.7;
            edge.put("weight", String.format("%.2f", weight));
            edges.add(edge);
            weights.add(weight);
        }

        for(int i = level1; i < level2; i ++){  // 第二层节点
            JSONObject node = new JSONObject();  // 创建新节点
            node.put("category", 2);
            node.put("name", String.valueOf(studentLst.get(i)));
            node.put("value", 20);
            nodes.add(node);
            for(int j = 0; j < r.nextInt(2) + 1; j ++){  // 第二层每个节点至少与一个第一层节点相连
                JSONObject edge = new JSONObject();  // 创建新边
                edge.put("source", String.valueOf(studentLst.get(r.nextInt(4))));
                edge.put("target", String.valueOf(studentLst.get(i)));
                edge.put("weight", String.format("%.2f", r.nextDouble() * 0.3 + 0.7));
                edges.add(edge);
            }
        }

        for(int i = level2; i < 40; i ++){  // 第三层节点
            JSONObject node = new JSONObject();  // 创建新节点
            node.put("category", 3);
            node.put("name", String.valueOf(studentLst.get(i)));
            node.put("value", 10);
            nodes.add(node);
            for(int j = 0; j < r.nextInt(2) + 1; j ++){  // 第二层每个节点至少与一个第一层节点相连
                JSONObject edge = new JSONObject();
                edge.put("source", String.valueOf(studentLst.get(r.nextInt(level2 - level1 - 1) + 5)));
                edge.put("target", String.valueOf(studentLst.get(i)));
                edge.put("weight", String.format("%.2f", r.nextDouble() * 0.3 + 0.7));
                edges.add(edge);
            }
        }

        // 排序
        for(int i = 0; i < level1; i ++){
            for(int j = 0; j < level1 - i - 1; j ++){
                if(weights.get(j) < weights.get(j + 1)){
                    // 交换weights数组中数据位置
                    Double tempWeight = weights.get(j);
                    weights.set(j, weights.get(j + 1));
                    weights.set(j + 1, tempWeight);
                    // 交换recommendIds数组中数据中位置
                    Integer tempId = recommendIds.get(j);
                    recommendIds.set(j, recommendIds.get(j + 1));
                    recommendIds.set(j + 1, tempId);
                }
            }
        }

        JSONArray recommendFriends = new JSONArray();
        List<Integer> friendIdLst = friendService.getFIdByUid(Integer.valueOf(user.getUserid()));  // 好友Id列表
        int i = 0;
        while(i < 3){  // 删除已成为好友的ID
            if(friendIdLst.contains(recommendIds.get(i))){
                recommendIds.remove(i);
                weights.remove(i);
                continue;
            }
            JSONObject recommendFriend = new JSONObject();
            String course = userService.getModuleNameByUserid(recommendIds.get(i)).get(0);
            int img = r.nextInt(10) + 1;
            recommendFriend.put("id", recommendIds.get(i));
            recommendFriend.put("img", img);
            recommendFriend.put("weight", String.format("%.2f", weights.get(i)));
            recommendFriend.put("course", course);
            recommendFriends.add(recommendFriend);
            i ++;
        }
        result.put("nodes", nodes);
        result.put("edges", edges);
        result.put("recommendFriends", recommendFriends);
        result.put("userid", user.getUserid());
        String jsonString = JSON.toJSONString(result);
        return jsonString;
    }

    @RequestMapping(path = "/userCountInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String userCountInfo(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Double> trustList = userService.getTrustByUid(user.getUserid());
        String message;
        if(trustList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("trustList", trustList);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    @RequestMapping(path = "/studentScore", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentScore(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<StudentInfo> courseList = userService.getUserInfoById(user.getUserid());
        List<Assessment> scoreList = new ArrayList<>();
        Course learnLength = new Course();
        String message;
        if(courseList != null){
            scoreList = userService.getStudentScoreByStuid(user.getUserid(), courseList.get(0).getCode_module(), courseList.get(0).getCode_presentation());
            learnLength = userService.getLearnLength(user.getUserid(), courseList.get(0).getCode_module(), courseList.get(0).getCode_presentation());
            if(scoreList != null && learnLength != null){
                message = "success";
            }else{
                message = "fail";
            }
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("courseList", courseList);
        map.put("scoreList", scoreList);
        map.put("learnLength", learnLength.getModule_presentation_length() - learnLength.getDate_registration());
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    @RequestMapping(path = "/studentOtherInfo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentOtherInfo(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        int resourceCount = resourceService.getResourceCountByUid(user.getUserid());
        int resourceClick = userService.getVleClickByUid(user.getUserid());
        int friendCount = friendService.getFriendCountByUid(user.getUserid());
        String message;
        if(resourceCount != -1 && resourceClick != -1 && friendCount != -1){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("resourceCount", resourceCount);
        map.put("resourceClick", resourceClick);
        map.put("friendCount", friendCount);
        map.put("userid", user.getUserid());
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }

    @RequestMapping(path = "/applyMessage", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String applyMessage(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<FriendApply> friendApplyList = friendService.getToPassFriendApplyByUid(user.getUserid());
        List<ResourceApply> resourceApplyList = resourceService.getToPassResourceApplyByUid(user.getUserid());
        String message;
        if(friendApplyList != null && resourceApplyList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("friendApplyList", friendApplyList);
        map.put("resourceApplyList", resourceApplyList);
        String jsonString = JSON.toJSONString(map);
        return jsonString;
    }
}

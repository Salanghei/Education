package cn.edu.hit.ices.yang.controller;

import cn.edu.hit.ices.yang.model.Resource;
import cn.edu.hit.ices.yang.model.User;
import cn.edu.hit.ices.yang.service.ResourceService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    @javax.annotation.Resource
    private ResourceService resourceService;

    // 获取全部已通过审核的资源
    @RequestMapping(path = "/allPassResources", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String allPassResources(){
        List<Resource> passResourcesList = resourceService.getAllPassResources();
        String message;
        if(passResourcesList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("passResourcesList", passResourcesList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取某用户已通过审核的资源
    @RequestMapping(path = "passResourcesByUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passResourcesByUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Resource> passResourcesList = resourceService.getPassResourcesByUser(user.getUserid());
        String message;
        if(passResourcesList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("passResourcesList", passResourcesList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取某用户待审核的资源
    @RequestMapping(path = "toPassResourcesByUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String toPassResourcesByUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        System.out.println("email: " + user.getEmail());
        List<Resource> toPassResourceList = resourceService.getToPassResourcesByUser(user.getUserid());
        String message;
        if(toPassResourceList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("toPassResourceList", toPassResourceList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取某用户未通过审核的资源
    @RequestMapping(path = "notPassResourcesByUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String notPassResourcesByUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Resource> notPassResourceList = resourceService.getNotPassResourcesByUser(user.getUserid());
        String message;
        if(notPassResourceList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("notPassResourceList", notPassResourceList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取某ID的资源
    @RequestMapping(path = "resourcesById", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String resourcesById(@Param("resourceid")String resourceid,
                                HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Resource> resourceList = resourceService.getResourcesById(Integer.valueOf(resourceid));
        String message, auth;
        if(resourceList != null){
            if(resourceList.get(0).getUserid() == user.getUserid()){
                auth = "thisUser";
            }else{
                auth = "notThisUser";
            }
            message = "success";
        }else{
            message = "fail";
            auth = "";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("auth", auth);
        map.put("resourceList", resourceList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取某用户以获取到下载权限的资源
    @RequestMapping(path = "resourcesByAuth", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String resourcesByAuth(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Resource> authResourceList = resourceService.getResourceByAuth(String.valueOf(user.getUserid()));
        String message;
        if(authResourceList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("authResourceList", authResourceList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }
}

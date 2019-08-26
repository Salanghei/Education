package cn.edu.hit.ices.yang.controller;

import cn.edu.hit.ices.yang.model.Friend;
import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;
import cn.edu.hit.ices.yang.service.FriendService;
import cn.edu.hit.ices.yang.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/friend")
public class FriendController {
    @Resource
    private FriendService friendService;

    @Resource
    private UserService userService;

    @RequestMapping(path = "/friendByUid", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String friendByUid(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Friend> friendList = friendService.getFriendByUid(user.getUserid());
        List<StudentInfo> studentInfoList = new ArrayList<>();
        String message;
        if(friendList != null){
            message = "success";
            for(Friend friend : friendList){
                StudentInfo studentInfo = userService.getUserInfoById(friend.getFid()).get(0);
                studentInfoList.add(studentInfo);
            }
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("friendList", friendList);
        map.put("studentInfoList", studentInfoList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }
}

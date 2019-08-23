package cn.edu.hit.ices.yang.controller;

import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;
import cn.edu.hit.ices.yang.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

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
                StudentInfo studentInfo = userService.getUserInfoById(user.getUserid());  // 获取用户信息
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
}

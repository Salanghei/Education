package cn.edu.hit.ices.yang.controller;

import cn.edu.hit.ices.yang.model.Assessment;
import cn.edu.hit.ices.yang.model.ChartData;
import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.service.CourseService;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    // 获取所有课程的列表
    @RequestMapping(path = "/allCourses", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String allCourses(){
        List<String> allCoursesList = courseService.getAllCourses();  // 所有课程列表
        List<Integer> userCountList = new ArrayList<>();
        String message;
        if(allCoursesList != null){
            message = "success";
            for(String course : allCoursesList){  // 统计每门课程的选课人次
                int usercount = courseService.getCourseUserCount(course);
                userCountList.add(usercount);
            }
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("allCoursesList", allCoursesList);
        map.put("userCountList", userCountList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取课程的相关信息列表
    @RequestMapping(path = "/courseMes", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String courseMes(@Param("code_module")String code_module){
        List<String> preList = courseService.getPreByModule(code_module);  // 课程学期列表
        List<Assessment> assessmentList = courseService.getAssessmentByModule(code_module);  // 课程测验列表
        String message;
        if(preList != null && assessmentList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("preList", preList);
        map.put("assessmentList", assessmentList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 课程资源点击量柱状图
    @RequestMapping(path = "/studentVleClick", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentVleClick(@Param("code_module")String code_module){
        List<ChartData> vleClickList = courseService.getVleClickByModule(code_module);
        String message;
        if(vleClickList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("vleClickList", vleClickList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 测验成绩分布折线图
    @RequestMapping(path = "/scoreDistribution", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String scoreDistribution(@Param("id_assessment")String id_assessment){
        List<ChartData> scoreList = courseService.getScoreDistribution(Integer.valueOf(id_assessment));
        String message;
        if(scoreList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("scoreList", scoreList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 选课学生信息分布饼状图
    @RequestMapping(path = "/studentInfoCount", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentInfoCount(@Param("code_module")String code_module,
                                   @Param("code_presentation")String code_presentation){
        Map<String, List<ChartData>> infoMap = courseService.getStudentInfoCount(code_module, code_presentation);
        String message;
        if(infoMap != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("infoMap", infoMap);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 课程资源信息分布饼状图
    @RequestMapping(path = "/vleInfoCount", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String vleInfoCount(@Param("code_module")String code_module,
                                   @Param("code_presentation")String code_presentation){
        List<ChartData> infoList = courseService.getVleTypeCount(code_module, code_presentation);
        String message;
        if(infoList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("infoList", infoList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }

    // 获取学生选课列表，start为开始索引，count为每页数量
    @RequestMapping(path = "/studentList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String studentList(@Param("code_module")String code_module,
                              @Param("code_presentation")String code_presentation,
                              @Param("start")String start,
                              @Param("count")String count){
        List<StudentInfo> studentList = courseService.getStudentList(code_module, code_presentation,
                Integer.valueOf(start), Integer.valueOf(count));
        String message;
        if(studentList != null){
            message = "success";
        }else{
            message = "fail";
        }
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("studentList", studentList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        return jsonString;
    }
}

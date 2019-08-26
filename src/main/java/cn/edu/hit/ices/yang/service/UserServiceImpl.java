package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.*;
import cn.edu.hit.ices.yang.model.Assessment;
import cn.edu.hit.ices.yang.model.Course;
import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private StudentInfoMapper studentInfoMapper;

    @Resource
    private FriendMapper friendMapper;

    @Resource
    private AssessmentMapper assessmentMapper;

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private StudentVleMapper studentVleMapper;

    @Override
    public User getUserByUsername(String email){
        try{
            return userMapper.selectUserByUserName(email);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StudentInfo> getUserInfoById(int userid){
        try{
            return studentInfoMapper.selectUserInfoById(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> getRandomStudentID(int n){
        try{
            return studentInfoMapper.selectRandomStudentID(n);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getModuleNameByUserid(int id_student){
        try{
            return studentInfoMapper.selectModuleNameByUserid(id_student);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Double> getTrustByUid(int userid){
        try{
            return friendMapper.selectTrustByUid(userid);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Assessment> getStudentScoreByStuid(int id_student, String code_module, String code_presentation){
        try{
            return assessmentMapper.selectStudentScoreByStuid(id_student, code_module, code_presentation);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    // 获取某学生某课程的学习时长
    @Override
    public Course getLearnLength(int id_student, String code_module, String code_presentation){
        try{
            return courseMapper.selectLearnLength(id_student, code_module, code_presentation);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getVleClickByUid(int id_student){
        try{
            return studentVleMapper.selectVleClickByUid(id_student);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}

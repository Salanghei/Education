package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.StudentInfoMapper;
import cn.edu.hit.ices.yang.mapper.UserMapper;
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
    public StudentInfo getUserInfoById(int userid){
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
}

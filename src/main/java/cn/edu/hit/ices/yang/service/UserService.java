package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String email);

    StudentInfo getUserInfoById(int userid);

    List<Integer> getRandomStudentID(int n);

    List<String> getModuleNameByUserid(int id_student);
}
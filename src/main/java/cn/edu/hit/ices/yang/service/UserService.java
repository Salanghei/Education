package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;

public interface UserService {
    User getUserByUsername(String email);

    StudentInfo getUserInfoById(int userid);
}
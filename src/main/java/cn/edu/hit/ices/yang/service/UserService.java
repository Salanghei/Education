package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.Assessment;
import cn.edu.hit.ices.yang.model.Course;
import cn.edu.hit.ices.yang.model.StudentInfo;
import cn.edu.hit.ices.yang.model.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String email);

    List<StudentInfo> getUserInfoById(int userid);

    List<Integer> getRandomStudentID(int n);

    List<String> getModuleNameByUserid(int id_student);

    List<Double> getTrustByUid(int userid);

    List<Assessment> getStudentScoreByStuid(int id_student, String code_module, String code_presentation);

    Course getLearnLength(int id_student, String code_module, String code_presentation);

    int getVleClickByUid(int id_student);
}
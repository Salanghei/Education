package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.model.Assessment;
import cn.edu.hit.ices.yang.model.ChartData;
import cn.edu.hit.ices.yang.model.StudentInfo;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<String> getAllCourses();

    int getCourseUserCount(String code_module);

    List<StudentInfo> getStudentList(String code_module, String code_presentation, int start, int count);

    List<Assessment> getAssessmentByModule(String code_module);

    List<String> getPreByModule(String code_module);

    List<ChartData> getVleClickByModule(String code_module);

    List<ChartData> getScoreDistribution(int id_assessment);

    Map<String, List<ChartData>> getStudentInfoCount(String code_module, String code_presentation);

    List<ChartData> getVleTypeCount(String code_module, String code_presentation);
}

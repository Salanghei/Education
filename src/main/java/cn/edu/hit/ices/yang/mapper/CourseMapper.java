package cn.edu.hit.ices.yang.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseMapper")
public interface CourseMapper {
    List<String> selectAllCourses();

    List<String> selectPreByModule(String code_module);
}

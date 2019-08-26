package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseMapper")
public interface CourseMapper {
    List<String> selectAllCourses();

    List<String> selectPreByModule(String code_module);

    Course selectLearnLength(@Param("id_student") int id_student,
                                   @Param("code_module") String code_module,
                                   @Param("code_presentation") String code_presentation);
}

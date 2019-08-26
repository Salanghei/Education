package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Assessment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("assessmentMapper")
public interface AssessmentMapper {
    List<Assessment> selectAssessmentByModule(String code_module);

    List<Assessment> selectStudentScoreByStuid(@Param("id_student") int id_student,
                                               @Param("code_module") String code_module,
                                               @Param("code_presentation") String code_presentation);
}

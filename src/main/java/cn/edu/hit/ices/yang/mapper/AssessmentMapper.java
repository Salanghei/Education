package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.Assessment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("assessmentMapper")
public interface AssessmentMapper {
    List<Assessment> selectAssessmentByModule(String code_module);
}

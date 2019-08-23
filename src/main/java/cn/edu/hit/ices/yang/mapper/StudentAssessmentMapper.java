package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.ChartData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentAssessmentMapper")
public interface StudentAssessmentMapper {
    List<ChartData> selectScoreDistribution(int id_assessment);
}

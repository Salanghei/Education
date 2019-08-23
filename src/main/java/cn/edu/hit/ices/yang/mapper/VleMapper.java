package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.ChartData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vleMapper")
public interface VleMapper {
    List<ChartData> selectVleTypeCountByModule(String code_module);

    List<ChartData> selectVleTypeCountByModuleAndPre(@Param("code_module")String code_module,
                                                     @Param("code_presentation")String code_presentation);
}

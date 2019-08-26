package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.ChartData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentVleMapper")
public interface StudentVleMapper {
    List<ChartData> selectVleClickByModule(String code_module);

    int selectVleClickByUid(int id_student);
}

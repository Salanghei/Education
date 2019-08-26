package cn.edu.hit.ices.yang.mapper;

import cn.edu.hit.ices.yang.model.ChartData;
import cn.edu.hit.ices.yang.model.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentInfoMapper")
public interface StudentInfoMapper {
    int selectCourseUserCount(String code_module);

    List<StudentInfo> selectUserInfoById(int id_student);

    List<StudentInfo> selectStudentListByModule(@Param("code_module")String code_module,
                                                @Param("start")int start,
                                                @Param("count")int count);

    List<StudentInfo> selectStudentListByModuleAndPre(@Param("code_module")String code_module,
                                          @Param("code_presentation")String code_presentation,
                                          @Param("start")int start,
                                          @Param("count")int count);

    List<ChartData> selectGenderCountByModule(String code_module);

    List<ChartData> selectGenderCountByModuleAndPre(@Param("code_module")String code_module,
                                                    @Param("code_presentation")String code_presentation);

    List<ChartData> selectRegionCountByModule(String code_module);

    List<ChartData> selectRegionCountByModuleAndPre(@Param("code_module")String code_module,
                                                    @Param("code_presentation")String code_presentation);

    List<ChartData> selectEducationCountByModule(String code_module);

    List<ChartData> selectEducationCountByModuleAndPre(@Param("code_module")String code_module,
                                                       @Param("code_presentation")String code_presentation);

    List<ChartData> selectAgeCountByModule(String code_module);

    List<ChartData> selectAgeCountByModuleAndPre(@Param("code_module")String code_module,
                                                 @Param("code_presentation")String code_presentation);

    List<ChartData> selectImdCountByModule(String code_module);

    List<ChartData> selectImdCountByModuleAndPre(@Param("code_module")String code_module,
                                                 @Param("code_presentation")String code_presentation);

    List<Integer> selectRandomStudentID(int n);

    List<String> selectModuleNameByUserid(int id_student);
}

package cn.edu.hit.ices.yang.service;

import cn.edu.hit.ices.yang.mapper.*;
import cn.edu.hit.ices.yang.model.Assessment;
import cn.edu.hit.ices.yang.model.ChartData;
import cn.edu.hit.ices.yang.model.StudentInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService{
    @Resource
    private CourseMapper courseMapper;

    @Resource
    private StudentInfoMapper studentInfoMapper;

    @Resource
    private AssessmentMapper assessmentMapper;

    @Resource
    private StudentVleMapper studentVleMapper;

    @Resource
    private StudentAssessmentMapper studentAssessmentMapper;

    @Resource
    private VleMapper vleMapper;

    @Override
    public List<String> getAllCourses(){
        try{
            return courseMapper.selectAllCourses();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getCourseUserCount(String code_module){
        try{
            return studentInfoMapper.selectCourseUserCount(code_module);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<StudentInfo> getStudentList(String code_module, String code_presentation, int start, int count){
        try{
            if(code_presentation.equals("all")){
                return studentInfoMapper.selectStudentListByModule(code_module, start, count);
            }else{
                return studentInfoMapper.selectStudentListByModuleAndPre(code_module, code_presentation, start, count);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Assessment> getAssessmentByModule(String code_module){
        try{
            return assessmentMapper.selectAssessmentByModule(code_module);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getPreByModule(String code_module){
        try{
            return courseMapper.selectPreByModule(code_module);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChartData> getVleClickByModule(String code_module){
        try{
            return studentVleMapper.selectVleClickByModule(code_module);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChartData> getScoreDistribution(int id_assessment){
        try{
            return studentAssessmentMapper.selectScoreDistribution(id_assessment);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, List<ChartData>> getStudentInfoCount(String code_module, String code_presentation){
        try{
            Map<String, List<ChartData>> map = new HashMap<>();
            if(code_presentation.equals("all")){
                map.put("gender", studentInfoMapper.selectGenderCountByModule(code_module));
                map.put("education", studentInfoMapper.selectEducationCountByModule(code_module));
                map.put("region", studentInfoMapper.selectRegionCountByModule(code_module));
                map.put("age", studentInfoMapper.selectAgeCountByModule(code_module));
                map.put("img", studentInfoMapper.selectImdCountByModule(code_module));
            }else{
                map.put("gender", studentInfoMapper.selectGenderCountByModuleAndPre(code_module, code_presentation));
                map.put("education", studentInfoMapper.selectEducationCountByModuleAndPre(code_module, code_presentation));
                map.put("region", studentInfoMapper.selectRegionCountByModuleAndPre(code_module, code_presentation));
                map.put("age", studentInfoMapper.selectAgeCountByModuleAndPre(code_module, code_presentation));
                map.put("img", studentInfoMapper.selectImdCountByModuleAndPre(code_module, code_presentation));
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChartData> getVleTypeCount(String code_module, String code_presentation){
        try{
            if(code_presentation.equals("all")){
                return vleMapper.selectVleTypeCountByModule(code_module);
            }else{
                return vleMapper.selectVleTypeCountByModuleAndPre(code_module, code_presentation);
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

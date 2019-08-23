package cn.edu.hit.ices.yang.model;

public class Assessment {
    private String code_module;           // 课程名
    private String code_presentation;     // 开课学期
    private int id_assessment;            // 测验id
    private String assessment_type;       // 测验类型
    private int date;                     // 测验日期
    private int weight;                   // 测验所占权重

    public String getCode_module() {
        return code_module;
    }

    public void setCode_module(String code_module) {
        this.code_module = code_module;
    }

    public String getCode_presentation() {
        return code_presentation;
    }

    public void setCode_presentation(String code_presentation) {
        this.code_presentation = code_presentation;
    }

    public int getId_assessment() {
        return id_assessment;
    }

    public void setId_assessment(int id_assessment) {
        this.id_assessment = id_assessment;
    }

    public String getAssessment_type() {
        return assessment_type;
    }

    public void setAssessment_type(String assessment_type) {
        this.assessment_type = assessment_type;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

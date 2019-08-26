package cn.edu.hit.ices.yang.model;

public class Assessment {
    private String code_module;           // 课程名
    private String code_presentation;     // 开课学期
    private int id_assessment;            // 测验id
    private String assessment_type;       // 测验类型
    private int date;                     // 测验日期
    private int weight;                   // 测验所占权重

    private int id_student;               // 学生id
    private int date_submitted;
    private int is_banked;
    private float score;                  // 学生成绩

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

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getDate_submitted() {
        return date_submitted;
    }

    public void setDate_submitted(int date_submitted) {
        this.date_submitted = date_submitted;
    }

    public int getIs_banked() {
        return is_banked;
    }

    public void setIs_banked(int is_banked) {
        this.is_banked = is_banked;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}

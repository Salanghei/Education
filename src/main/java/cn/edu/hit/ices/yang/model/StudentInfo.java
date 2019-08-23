package cn.edu.hit.ices.yang.model;

public class StudentInfo {
    private String code_module;            // 课程名
    private String code_presentation;      // 课程学期
    private int id_student;                // 学生id
    private String gender;                 // 性别
    private String region;                 // 地区
    private String highest_education;      // 最高学历
    private String imd_band;               //
    private String age_band;               //
    private int num_of_prev_attempts;      // 此前该课程选课次数
    private int studied_credits;           // 当前选课学分总数
    private String disability;             //
    private String final_result;           // 学习结果

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

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHighest_education() {
        return highest_education;
    }

    public void setHighest_education(String highest_education) {
        this.highest_education = highest_education;
    }

    public String getImd_band() {
        return imd_band;
    }

    public void setImd_band(String imd_band) {
        this.imd_band = imd_band;
    }

    public String getAge_band() {
        return age_band;
    }

    public void setAge_band(String age_band) {
        this.age_band = age_band;
    }

    public int getNum_of_prev_attempts() {
        return num_of_prev_attempts;
    }

    public void setNum_of_prev_attempts(int num_of_prev_attempts) {
        this.num_of_prev_attempts = num_of_prev_attempts;
    }

    public int getStudied_credits() {
        return studied_credits;
    }

    public void setStudied_credits(int studied_credits) {
        this.studied_credits = studied_credits;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getFinal_result() {
        return final_result;
    }

    public void setFinal_result(String final_result) {
        this.final_result = final_result;
    }
}

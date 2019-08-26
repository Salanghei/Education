package cn.edu.hit.ices.yang.model;

public class Course {
    private String code_module;
    private String code_presentation;
    private int module_presentation_length;

    private int id_student;
    private int date_registration;
    private int date_unregistration;

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

    public int getModule_presentation_length() {
        return module_presentation_length;
    }

    public void setModule_presentation_length(int module_presentation_length) {
        this.module_presentation_length = module_presentation_length;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public int getDate_registration() {
        return date_registration;
    }

    public void setDate_registration(int date_registration) {
        this.date_registration = date_registration;
    }

    public int getDate_unregistration() {
        return date_unregistration;
    }

    public void setDate_unregistration(int date_unregistration) {
        this.date_unregistration = date_unregistration;
    }
}

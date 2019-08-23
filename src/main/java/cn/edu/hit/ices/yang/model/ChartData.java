package cn.edu.hit.ices.yang.model;

public class ChartData {
    private int field;  // int类型字段
    private String fieldStr;  // String类型字段
    private int data;   // 字段值

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getFieldStr() {
        return fieldStr;
    }

    public void setFieldStr(String fieldStr) {
        this.fieldStr = fieldStr;
    }
}

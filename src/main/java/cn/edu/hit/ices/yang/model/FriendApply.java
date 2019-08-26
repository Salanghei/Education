package cn.edu.hit.ices.yang.model;

public class FriendApply {
    private int id_apply;
    private int uid;
    private int fid;
    private String state;
    private String time;
    private String details;
    private double trust;

    public int getId_apply() {
        return id_apply;
    }

    public void setId_apply(int id_apply) {
        this.id_apply = id_apply;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getTrust() {
        return trust;
    }

    public void setTrust(double trust) {
        this.trust = trust;
    }
}

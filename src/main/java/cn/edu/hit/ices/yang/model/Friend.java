package cn.edu.hit.ices.yang.model;

public class Friend {
    private int uid;    // 登录用户ID
    private int fid;    // 登录用户的好友ID
    private double trust;  // 信任值

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

    public double getTrust() {
        return trust;
    }

    public void setTrust(double trust) {
        this.trust = trust;
    }
}

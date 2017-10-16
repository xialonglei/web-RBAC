package com.xll.model;

import java.util.Date;

public class OperateLogInfo {
    private Integer id;

    private Integer uid;

    private String uname;

    private Date createTime;

    private Date updateTime;

    private Boolean status;

    private String fromIp;

    private String operateFunc;

    private String visitMethod;

    private String visitMethodErrorInfo;

    private Date loginOutTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
    }

    public String getOperateFunc() {
        return operateFunc;
    }

    public void setOperateFunc(String operateFunc) {
        this.operateFunc = operateFunc == null ? null : operateFunc.trim();
    }

    public String getVisitMethod() {
        return visitMethod;
    }

    public void setVisitMethod(String visitMethod) {
        this.visitMethod = visitMethod == null ? null : visitMethod.trim();
    }

    public String getVisitMethodErrorInfo() {
        return visitMethodErrorInfo;
    }

    public void setVisitMethodErrorInfo(String visitMethodErrorInfo) {
        this.visitMethodErrorInfo = visitMethodErrorInfo == null ? null : visitMethodErrorInfo.trim();
    }

    public Date getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(Date loginOutTime) {
        this.loginOutTime = loginOutTime;
    }
}
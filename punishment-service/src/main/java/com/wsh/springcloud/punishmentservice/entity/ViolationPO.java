package com.wsh.springcloud.punishmentservice.entity;

import java.io.Serializable;

/**
 * @Description: 违纪PO对象
 * @author: weishihuai
 * @Date: 2019/3/4 12:00
 */
public class ViolationPO implements Serializable {
    /**
     * 主键ID
     */
    private String pkid;
    /**
     * 违纪名称
     */
    private String violationName;
    /**
     * 违纪类型
     */
    private String violationType;
    /**
     * 违纪学生ID
     */
    private String violationStuId;

    public ViolationPO() {
    }

    public ViolationPO(String pkid, String violationName, String violationType, String violationStuId) {
        this.pkid = pkid;
        this.violationName = violationName;
        this.violationType = violationType;
        this.violationStuId = violationStuId;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getViolationName() {
        return violationName;
    }

    public void setViolationName(String violationName) {
        this.violationName = violationName;
    }

    public String getViolationType() {
        return violationType;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public String getViolationStuId() {
        return violationStuId;
    }

    public void setViolationStuId(String violationStuId) {
        this.violationStuId = violationStuId;
    }
}

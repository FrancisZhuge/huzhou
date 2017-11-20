package com.dou.huzhou.domain;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: Francis Zhuge
 * @Description: 用户Bean
 * @Date: Created in 2017/11/20, 10:26
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class UserInfo {
    private Long id;
    private String userNo;
    private String username;
    private Long areaId;
    private Long buildingId;
    private Long companyId;
    private String password;
    private String salt;
    //是否锁定，默认锁定
    private Boolean lock= Boolean.TRUE;

    public UserInfo() {
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userNo='" + userNo + '\'' +
                ", username='" + username + '\'' +
                ", areaId=" + areaId +
                ", buildingId=" + buildingId +
                ", companyId=" + companyId +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", lock=" + lock +
                '}';
    }
}

package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 11:02
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class Company {
    private Long id;
    private String companyNo;
    private String companyName;
    private String address;
    private Long areaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyNo='" + companyNo + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", areaId=" + areaId +
                '}';
    }
}

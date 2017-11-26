package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 15:07
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class BuildingCompanyVo {
    private Long companyId;
    private String buildingName;
    private String companyName;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "BuildingCompanyVo{" +
                "companyId=" + companyId +
                ", buildingName='" + buildingName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}

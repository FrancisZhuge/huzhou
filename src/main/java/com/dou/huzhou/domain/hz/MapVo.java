package com.dou.huzhou.domain.hz;

public class MapVo {
    private Long companyId;
    private String companyName;
    private Double powerValue;
    private Double waterValue;
    //TRUE表示没有超过设定值
    //FALSE表示超过设定值
    //默认没有超过设定值
    private boolean energyState = Boolean.TRUE;
    private String BuildingName;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(Double powerValue) {
        this.powerValue = powerValue;
    }

    public Double getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(Double waterValue) {
        this.waterValue = waterValue;
    }

    public boolean isEnergyState() {
        return energyState;
    }

    public void setEnergyState(boolean energyState) {
        this.energyState = energyState;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }

    @Override
    public String toString() {
        return "MapVo{" +
                "companyName='" + companyName + '\'' +
                ", powerValue=" + powerValue +
                ", waterValue=" + waterValue +
                ", energyState=" + energyState +
                ", BuildingName='" + BuildingName + '\'' +
                '}';
    }
}

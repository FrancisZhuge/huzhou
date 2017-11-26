package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 10:41
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class Area {
    private Long id;
    private String areaNo;
    private String areaName;
    private Long proviceId;
    private Long cityId;
    private Long area_id;
    private String address;
    private String jigou;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getProviceId() {
        return proviceId;
    }

    public void setProviceId(Long proviceId) {
        this.proviceId = proviceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getArea_id() {
        return area_id;
    }

    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJigou() {
        return jigou;
    }

    public void setJigou(String jigou) {
        this.jigou = jigou;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", areaNo='" + areaNo + '\'' +
                ", areaName='" + areaName + '\'' +
                ", proviceId=" + proviceId +
                ", cityId=" + cityId +
                ", area_id=" + area_id +
                ", address='" + address + '\'' +
                ", jigou='" + jigou + '\'' +
                '}';
    }
}

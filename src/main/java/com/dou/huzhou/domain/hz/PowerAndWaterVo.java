package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 16:47
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PowerAndWaterVo {
    private String time;
    private Double powerValue;
    private Double waterValue;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "PowerAndWaterVo{" +
                "time='" + time + '\'' +
                ", powerValue=" + powerValue +
                ", waterValue=" + waterValue +
                '}';
    }
}

package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 20:50
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PowerDo {
    private String time;
    private Double powerValue;

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

    @Override
    public String toString() {
        return "PowerDo{" +
                "time='" + time + '\'' +
                ", powerValue=" + powerValue +
                '}';
    }
}

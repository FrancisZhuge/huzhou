package com.dou.huzhou.domain.hz;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 20:26
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class WaterDo {
    private int time;
    private Double waterValue;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Double getWaterValue() {
        return waterValue;
    }

    public void setWaterValue(Double waterValue) {
        this.waterValue = waterValue;
    }

    @Override
    public String toString() {
        return "WaterDo{" +
                "time='" + time + '\'' +
                ", waterValue=" + waterValue +
                '}';
    }
}

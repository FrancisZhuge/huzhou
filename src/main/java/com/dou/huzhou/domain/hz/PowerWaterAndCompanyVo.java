package com.dou.huzhou.domain.hz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 13:56
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PowerWaterAndCompanyVo implements Comparable<PowerWaterAndCompanyVo>{
    private String companyName;
    private Double powerValue;
    private Double waterValue;

    public PowerWaterAndCompanyVo() {
    }

    public PowerWaterAndCompanyVo(Double powerValue, Double waterValue) {
        this.powerValue = powerValue;
        this.waterValue = waterValue;
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

    @Override
    public int compareTo(PowerWaterAndCompanyVo o) {
        if (o.getPowerValue()>this.getPowerValue()){
            return 1;
        }else if (o.getPowerValue()<this.getPowerValue()){
            return -1;
        }else {
            if(o.getWaterValue()>this.getWaterValue()){
                return 1;
            }else if (o.getWaterValue()<this.getWaterValue()){
                return -1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "PowerWaterAndCompanyVo{" +
                "companyName='" + companyName + '\'' +
                ", powerValue=" + powerValue +
                ", waterValue=" + waterValue +
                '}';
    }
}

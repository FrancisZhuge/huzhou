package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/29, 15:57
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PowerPeakAndVallyDo {
    private Double tip;
    private Double peak;
    private Double vally;
    private Double powerValue;

    public Double getTip() {
        return tip;
    }

    public void setTip(Double tip) {
        this.tip = tip;
    }

    public Double getPeak() {
        return peak;
    }

    public void setPeak(Double peak) {
        this.peak = peak;
    }

    public Double getVally() {
        return vally;
    }

    public void setVally(Double vally) {
        this.vally = vally;
    }

    public Double getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(Double powerValue) {
        this.powerValue = powerValue;
    }

    @Override
    public String toString() {
        return "PowerPeakAndVallyDo{" +
                "tip=" + tip +
                ", peak=" + peak +
                ", vally=" + vally +
                ", powerValue=" + powerValue +
                '}';
    }
}

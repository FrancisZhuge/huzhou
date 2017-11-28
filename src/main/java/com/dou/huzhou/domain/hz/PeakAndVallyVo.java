package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/28, 9:38
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PeakAndVallyVo {
    private String time;
    //尖能耗
    private Double tip;
    //峰能耗
    private Double peak;
    //谷能耗
    private Double vally;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

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

    @Override
    public String toString() {
        return "PeakAndVallyVo{" +
                "time='" + time + '\'' +
                ", tip=" + tip +
                ", peak=" + peak +
                ", vally=" + vally +
                '}';
    }
}

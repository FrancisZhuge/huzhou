package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/28, 9:43
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class PeakAndVallyDo {
    private int time;
    //尖能耗
    private Double tip;
    //峰能耗
    private Double peak;
    //谷能耗
    private Double vally;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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
        return "PeakAndVallyDo{" +
                "time=" + time +
                ", tip=" + tip +
                ", peak=" + peak +
                ", vally=" + vally +
                '}';
    }
}

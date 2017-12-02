package com.dou.huzhou.domain.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 10:41
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class EnergyConsumptionVo {
    //公司名称  company_name
    private String companyName;
    //电压      uan
    private Double voltage;
    //电流      ia
    private Double electricity;
    //有功功率  ps
    private Double activePower;
    //总功率    ps
    private Double totalPower;
    //功率因数  pfs
    private Double powerFactor;
    //总功率因数 pfs
    private Double totalPowerFactor;
    //有功总电能  by_kwhz
    private Double totalActiveEnergy;
    //有功尖电能  by_kwhj
    private Double powerfulTipEnergy;
    //有功峰电能  by_kwhf
    private Double powerfulPeakEnergy;
    //有功谷电能  by_hwhg
    private Double powerfulValleyEnergy;
    //倍率       rate
    private Double rate;
    //时间         read_time
    private String time;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getElectricity() {
        return electricity;
    }

    public void setElectricity(Double electricity) {
        this.electricity = electricity;
    }

    public Double getActivePower() {
        return activePower;
    }

    public void setActivePower(Double activePower) {
        this.activePower = activePower;
    }

    public Double getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(Double totalPower) {
        this.totalPower = totalPower;
    }

    public Double getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(Double powerFactor) {
        this.powerFactor = powerFactor;
    }

    public Double getTotalPowerFactor() {
        return totalPowerFactor;
    }

    public void setTotalPowerFactor(Double totalPowerFactor) {
        this.totalPowerFactor = totalPowerFactor;
    }

    public Double getTotalActiveEnergy() {
        return totalActiveEnergy;
    }

    public void setTotalActiveEnergy(Double totalActiveEnergy) {
        this.totalActiveEnergy = totalActiveEnergy;
    }

    public Double getPowerfulTipEnergy() {
        return powerfulTipEnergy;
    }

    public void setPowerfulTipEnergy(Double powerfulTipEnergy) {
        this.powerfulTipEnergy = powerfulTipEnergy;
    }

    public Double getPowerfulPeakEnergy() {
        return powerfulPeakEnergy;
    }

    public void setPowerfulPeakEnergy(Double powerfulPeakEnergy) {
        this.powerfulPeakEnergy = powerfulPeakEnergy;
    }

    public Double getPowerfulValleyEnergy() {
        return powerfulValleyEnergy;
    }

    public void setPowerfulValleyEnergy(Double powerfulValleyEnergy) {
        this.powerfulValleyEnergy = powerfulValleyEnergy;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EnergyConsumptionVo{" +
                "companyName='" + companyName + '\'' +
                ", voltage=" + voltage +
                ", electricity=" + electricity +
                ", activePower=" + activePower +
                ", totalPower=" + totalPower +
                ", powerFactor=" + powerFactor +
                ", totalPowerFactor=" + totalPowerFactor +
                ", totalActiveEnergy=" + totalActiveEnergy +
                ", powerfulTipEnergy=" + powerfulTipEnergy +
                ", powerfulPeakEnergy=" + powerfulPeakEnergy +
                ", powerfulValleyEnergy=" + powerfulValleyEnergy +
                ", rate=" + rate +
                ", time='" + time + '\'' +
                '}';
    }

    public static void main(String[] args) {
        EnergyConsumptionVo energyConsumptionVo = new EnergyConsumptionVo();
        System.out.println(energyConsumptionVo);
    }
}

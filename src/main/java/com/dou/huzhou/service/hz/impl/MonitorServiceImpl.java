package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.MonitorDao;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.*;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.MonitorService;
import com.dou.huzhou.service.hz.PowerService;
import com.dou.huzhou.service.hz.RoleService;
import com.dou.huzhou.service.hz.WaterService;
import com.dou.huzhou.utils.hz.TimeUtil;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 15:24
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class MonitorServiceImpl implements MonitorService{
    private final static Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);

    @Autowired
    private MonitorDao monitorDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private WaterService waterService;

    @Override
    public List<BuildingCompanyVo> getInfo(Subject user) {
        UserInfo userInfo = userService.getByUsername((String) user.getPrincipal());
        List<BuildingCompanyVo> buildingCompanyVos = null;
        if(userInfo.getAreaId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有admin权限
                //取出所有值
                //todo：这里直接使用了1L，等待改进
                buildingCompanyVos = getInfoByArea(1l);
            }
        }else if(userInfo.getCompanyId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.admin权限
                //取出所有值
                buildingCompanyVos = getInfoByArea(userInfo.getAreaId());
            }
        }else {
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.{company}.admin权限
                //取出该公司的所有值
                buildingCompanyVos = getInfoByAreaAndCompany(userInfo.getAreaId(), userInfo.getCompanyId());
            }else{
                //没有权限
                //返回空
            }
        }
        return buildingCompanyVos;
    }

    @Override
    public List<BuildingCompanyVo> getInfoByArea(Long areaId) {
        List<BuildingCompanyVo> buildingCompanyVos = null;
        try {
            buildingCompanyVos = monitorDao.getInfoByArea(areaId);
        } catch (Exception e) {
            LOGGER.error("getInfoByArea dao failed");
        }
        return buildingCompanyVos;
    }

    @Override
    public List<BuildingCompanyVo> getInfoByAreaAndCompany(Long areaId, Long companyId) {
        List<BuildingCompanyVo> buildingCompanyVos = null;
        try {
            buildingCompanyVos = monitorDao.getInfoByCompany(areaId,companyId);
        } catch (Exception e) {
            LOGGER.error("getInfoByAreaAndCompany dao failed");
        }
        return buildingCompanyVos;
    }

    @Override
    public List<PowerAndWaterVo> getPowerAndWaterPerHour(Long companyId) {
        double[] powerValue = getPowerPerHour(companyId);
        double[] waterValue = getWaterPerHour(companyId);
        List<PowerAndWaterVo> powerAndWaterVos = new ArrayList<>();
        for(int i=0;i<24;i++){
            PowerAndWaterVo powerAndWaterVo = new PowerAndWaterVo();
            powerAndWaterVo.setTime(TimeUtil.getTodayTimeByHour(i+1));
            powerAndWaterVo.setPowerValue(powerValue[i]);
            powerAndWaterVo.setWaterValue(waterValue[i]);
            powerAndWaterVos.add(powerAndWaterVo);
        }
        return powerAndWaterVos;
    }

    /**
     根据{companyId} 来获取公司当天的分时用电情况
     * @param companyId
     * @return
     */
    private double[] getPowerPerHour(Long companyId) {
        double[] temp = new double[25];
        double[] powerValue = new double[24];
        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            double[] before = new double[25];
            List<PowerDo> powerDos = powerService.getPowerPerHour(powerIds[i]);
            //规整
            for(PowerDo powerDo:powerDos){
                before[powerDo.getTime()+1] = powerDo.getPowerValue();
            }
            //前一天的读数
            double powerLastOneYesterday = powerService.getPowerLastOneYesterday(powerIds[i]);
            before[0] = powerLastOneYesterday;
            for(int j=1;j<25;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<25;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<24;i++){
            powerValue[i] = temp[i+1]-temp[i];
        }
        return powerValue;
    }

    /**
     根据{companyId} 来获取公司当天的分时用水情况
     * @param companyId
     * @return
     */
    private double[] getWaterPerHour(Long companyId) {
        double[] temp = new double[25];
        double[] waterValue = new double[24];
        Long[] waterIds = waterService.getWaterIds(companyId);
        for(int i=0;i<waterIds.length;i++){
            double[] before = new double[25];
            List<WaterDo> waterDos = waterService.getWaterPerHour(waterIds[i]);
            //规整
            for(WaterDo waterDo:waterDos){
                before[waterDo.getTime()+1] = waterDo.getWaterValue();
            }
            //前一天的读数
            double waterLastOneYesterday = waterService.getWaterLastOneYesterday(waterIds[i]);
            before[0] = waterLastOneYesterday;
            for(int j=1;j<25;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<25;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<24;i++){
            waterValue[i] = temp[i+1]-temp[i];
        }
        return waterValue;
    }

    @Override
    public List<PowerAndWaterVo> getPowerAndWaterPerDay(Long companyId) {
        double[] waterValuePerDay = getWaterPerDay(companyId);
        double[] powerValuePerDay = getPowerPerDay(companyId);
        List<PowerAndWaterVo> powerAndWaterVos = new ArrayList<>();
        int days = TimeUtil.getThisMonthDays();
        for(int i=0;i<days;i++){
            PowerAndWaterVo powerAndWaterVo = new PowerAndWaterVo();
            powerAndWaterVo.setTime(TimeUtil.getTimeByDay(i+1));
            powerAndWaterVo.setWaterValue(waterValuePerDay[i]);
            powerAndWaterVo.setPowerValue(powerValuePerDay[i]);
            powerAndWaterVos.add(powerAndWaterVo);
        }
        return powerAndWaterVos;
    }

    /**
     * 根据{companyId} 来获取公司当月的分天用电和用水情况（每天，最后一个数值作为这个时间段的结束值）
     * @param companyId
     * @return
     */
    private double[] getWaterPerDay(Long companyId) {
        int days = TimeUtil.getThisMonthDays();
        double[] temp = new double[days+1];
        double[] waterValue = new double[days];
        Long[] waterIds = waterService.getWaterIds(companyId);
        for(int i=0;i<waterIds.length;i++){
            double[] before = new double[days+1];
            List<WaterDo> waterDos = waterService.getWaterPerDay(waterIds[i]);
            //规整
            for(WaterDo waterDo:waterDos){
                before[waterDo.getTime()] = waterDo.getWaterValue();
            }
            Double lastMonthValue = waterService.getLastMonthValue(waterIds[i]);
            before[0] = lastMonthValue;
            for(int j=1;j<days+1;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<days+1;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<days;i++){
            waterValue[i] = temp[i+1]-temp[i];
        }
        return waterValue;
    }
    /**
     * 根据{companyId}来获取公司当月的每日用电情况（每天最后一条数据为准）
     * @param companyId
     * @return
     */
    private double[] getPowerPerDay(Long companyId) {
        int days = TimeUtil.getThisMonthDays();
        double[] temp = new double[days+1];
        double[] powerValue = new double[days];
        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            double[] before = new double[days+1];
            List<PowerDo> powerDos = powerService.getPowerPerDay(powerIds[i]);
            //规整
            for(PowerDo powerDo:powerDos){
                before[powerDo.getTime()] = powerDo.getPowerValue();
            }
            Double lastMonthValue = powerService.getLastMonthValue(powerIds[i]);
            before[0] = lastMonthValue;
            for(int j=1;j<days+1;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<days+1;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<days;i++){
            powerValue[i] = temp[i+1]-temp[i];
        }
        return powerValue;
    }

    @Override
    public List<PowerAndWaterVo> getPowerAndWaterByPercentage(Integer day, Long companyId) {
        double[] waterValueByPercentage = getWaterValueByPercentage(day, companyId);
        double[] powerValueByPercentage = getPowerValueByPercentage(day, companyId);
        List<PowerAndWaterVo> powerAndWaterVos = new ArrayList<>();
        for(int i=0;i<24;i++){
            PowerAndWaterVo powerAndWaterVo = new PowerAndWaterVo();
            powerAndWaterVo.setTime(TimeUtil.getTimeByDayAndHour(day,i+1));
            powerAndWaterVo.setWaterValue(waterValueByPercentage[i]);
            powerAndWaterVo.setPowerValue(powerValueByPercentage[i]);
            powerAndWaterVos.add(powerAndWaterVo);
        }
        return powerAndWaterVos;
    }

    /**
     * 根据time和company_id来获取公司的能耗百分比图。
     * @param day
     * @param companyId
     * @return
     */
    private double[] getWaterValueByPercentage(Integer day, Long companyId){
        double[] temp = new double[25];
        double[] waterValue = new double[24];
        Long[] waterIds = waterService.getWaterIds(companyId);
        for(int i=0;i<waterIds.length;i++){
            double[] before = new double[25];
            List<WaterDo> waterDos = waterService.getWaterByPercentage(day, waterIds[i]);
            //规整
            for(WaterDo waterDo:waterDos){
                before[waterDo.getTime()+1] = waterDo.getWaterValue();
            }
            //更新第0个值
            Double waterLastOneYesterday = waterService.getWaterLastOneYesterday(day, waterIds[i]);
            before[0] = waterLastOneYesterday;
            for(int j=1;j<25;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<25;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<24;i++){
            waterValue[i] = temp[i+1]-temp[i];
        }
        return waterValue;
    }


    /**
     * 根据time和company_id来获取公司的能耗百分比图。
     * @param day
     * @param companyId
     * @return
     */
    private double[] getPowerValueByPercentage(Integer day, Long companyId){
        double[] temp = new double[25];
        double[] powerValue = new double[24];
        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            double[] before = new double[25];
            List<PowerDo> powerDos = powerService.getPowerByPercentage(day, powerIds[i]);
            //规整
            for(PowerDo powerDo:powerDos){
                before[powerDo.getTime()] = powerDo.getPowerValue();
            }
            //更新第0个值
            Double powerLastOneYesterday = powerService.getPowerLastOneYesterday(day, powerIds[i]);
            before[0] = powerLastOneYesterday;
            for(int j=1;j<25;j++){
                if(before[j]==0D&&before[j-1]!=0D){
                    before[j]=before[j-1];
                }
            }
            for(int j=0;j<25;j++){
                temp[j] = temp[j]+before[j];
            }
        }
        //相减
        for(int i=0;i<24;i++){
            powerValue[i] = temp[i+1]-temp[i];
        }
        return powerValue;
    }

    @Override
    public List<PeakAndVallyVo> getPeakAndVally(Integer year, Integer month, Long companyId) {
        double[][] peakAndVallyValue = getPeakAndVallyValue(year, month, companyId);
        List<PeakAndVallyVo> peakAndVallyVos = new ArrayList<>();
        for(int i=0;i<TimeUtil.getDaysByYearAndMonth(year,month);i++){
            PeakAndVallyVo peakAndVallyVo = new PeakAndVallyVo();
            peakAndVallyVo.setTime(TimeUtil.getTimeByYearAndMonth(year,month,i+1));
            peakAndVallyVo.setTip(peakAndVallyValue[0][i]);
            peakAndVallyVo.setPeak(peakAndVallyValue[1][i]);
            peakAndVallyVo.setVally(peakAndVallyValue[2][i]);
            peakAndVallyVos.add(peakAndVallyVo);
        }
        return peakAndVallyVos;
    }

    /**
     * 根据{year} {month} {companyId}获取该公司的峰谷消耗情况
     * @param year
     * @param month
     * @param companyId
     * @return
     */
    private double[][] getPeakAndVallyValue(Integer year, Integer month, Long companyId) {
        //获取当月有多少天
        int days = TimeUtil.getDaysByYearAndMonth(year, month);
        double[][] temp = new double[3][days+1];
        double[][] powerValue = new double[3][days];
        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            double[][] before = new double[3][days+1];
            List<PeakAndVallyDo> peakAndVallyDos = powerService.getPeakAndVally(year, month, powerIds[i]);
            //规整
            for(PeakAndVallyDo peakAndVallyDo:peakAndVallyDos){
                before[0][peakAndVallyDo.getTime()] = peakAndVallyDo.getTip();//尖
                before[1][peakAndVallyDo.getTime()] = peakAndVallyDo.getPeak();//峰
                before[2][peakAndVallyDo.getTime()] = peakAndVallyDo.getVally();//谷
            }
            //更新0个值
            PeakAndVallyDo lastMonthPeakAndVally = powerService.getLastMonthPeakAndVally(year, month, powerIds[i]);
            before[0][0] = lastMonthPeakAndVally.getTip();//尖
            before[1][0] = lastMonthPeakAndVally.getPeak();//峰
            before[2][0] = lastMonthPeakAndVally.getVally();//谷
            for (int s=0;s<3;s++){
                for(int t=1;t<days+1;t++){
                    if (before[s][t]==0D&&before[s][t-1]!=0){
                        before[s][t]=before[s][t-1];
                    }
                }
            }
            for (int s=0;s<3;s++){
                for(int t=0;t<days+1;t++){
                    temp[s][t]=temp[s][t]+before[s][t];
                }
            }
        }
        //相减
        for(int i=0;i<3;i++){
            for(int j=0;j<days;j++){
                powerValue[i][j]=temp[i][j+1]-temp[i][j];
            }
        }
        return powerValue;
    }











}

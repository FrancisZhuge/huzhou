package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.domain.hz.*;
import com.dou.huzhou.service.hz.AnalysisService;
import com.dou.huzhou.service.hz.PowerService;
import com.dou.huzhou.utils.hz.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/29, 9:28
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService{
    private final static Logger LOGGER = LoggerFactory.getLogger(AnalysisServiceImpl.class);

    @Autowired
    private PowerService powerService;

    @Override
    public List<PowerVo> getCurrentWeek(Long companyId){
        double[] temp = new double[8];
        double[] powerValue = new double[7];
        String[] currentWeek = TimeUtil.getCurrentWeek();

        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            for(int j=0;j<8;j++){
                temp[j] += powerService.getPowerLastOneAtTime(powerIds[i],currentWeek[j]);
            }
        }
        for(int i=0;i<7;i++){
            powerValue[i]=temp[i+1]-temp[i];
        }
        List<PowerVo> powerVos = new ArrayList<>();
        for(int i=0;i<7;i++){
            PowerVo powerVo = new PowerVo();
            powerVo.setTime(currentWeek[i+1]);
            powerVo.setPowerValue(powerValue[i]);
            powerVos.add(powerVo);
        }
        return powerVos;
    }

    @Override
    public List<PowerPeakAndVallyVo> getEnergyConsumption(Long companyId) {
        double[][] temp = new double[4][8];
        double[][] powerValue = new double[4][7];
        String[] currentWeek = TimeUtil.getCurrentWeek();
        Long[] powerIds = powerService.getPowerIds(companyId);
        for(int i=0;i<powerIds.length;i++){
            for(int j=0;j<8;j++){
                PowerPeakAndVallyDo powerPeakAndVallyDo = powerService.getPowerPeakAndVallyAtTime(powerIds[i], currentWeek[j]);

                temp[0][j] += temp[0][j] + powerPeakAndVallyDo.getPowerValue();
                temp[1][j] += temp[1][j] + powerPeakAndVallyDo.getTip();
                temp[2][j] += temp[2][j] + powerPeakAndVallyDo.getPeak();
                temp[3][j] += temp[3][j] + powerPeakAndVallyDo.getVally();
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<7;j++){
                powerValue[i][j]=temp[i][j+1]-temp[i][j];
            }
        }
        List<PowerPeakAndVallyVo> powerPeakAndVallyVos = new ArrayList<>();
        for(int i=0;i<7;i++){
            PowerPeakAndVallyVo powerPeakAndVally = new PowerPeakAndVallyVo();
            powerPeakAndVally.setTime(currentWeek[i+1]);
            powerPeakAndVally.setPowerValue(powerValue[0][i]);
            powerPeakAndVally.setTip(powerValue[1][i]);
            powerPeakAndVally.setPeak(powerValue[2][i]);
            powerPeakAndVally.setVally(powerValue[3][i]);
            powerPeakAndVallyVos.add(powerPeakAndVally);
        }
        return powerPeakAndVallyVos;
    }

    @Override
    public List<PowerVo> getEnergyByMonth(Long companyId) {
        return null;
    }
}

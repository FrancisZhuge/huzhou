package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.domain.hz.PowerAndWaterVo;
import com.dou.huzhou.domain.hz.PowerDo;
import com.dou.huzhou.domain.hz.PowerVo;
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
        double value = 0d;
        for(int i=0;i<powerIds.length;i++){
            for(int j=0;j<8;j++){
                value = powerService.getPowerLastOneAtTime(powerIds[i],currentWeek[j]);
                temp[j] += value;
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
}

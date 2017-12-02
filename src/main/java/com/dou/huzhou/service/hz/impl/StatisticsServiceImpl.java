package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.domain.hz.PowerWaterAndCompanyVo;
import com.dou.huzhou.service.hz.CompanyService;
import com.dou.huzhou.service.hz.PowerService;
import com.dou.huzhou.service.hz.StatisticsService;
import com.dou.huzhou.service.hz.WaterService;
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
 * @Date: Created in 2017/11/30, 12:37
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService{
    private final static Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private WaterService waterService;

    @Override
    public Double getCoal() {
        Double value = 0D;
        try {
            Long[] companyIds = companyService.getCompanyIds(1L);
            for(Long companyId:companyIds){
                Long[] powerIds = powerService.getPowerIds(companyId);
                for(Long powerId:powerIds){
                    Double lastValue = powerService.getLastValue(powerId);
                    value += lastValue;
                }
            }
        } catch (Exception e) {
            LOGGER.error("getCoal failed. ",e);
        }
        return value;
    }

    @Override
    public List<PowerWaterAndCompanyVo> getPowerAndWaterByOrder() {
        List<PowerWaterAndCompanyVo> powerWaterAndCompanyVos = new ArrayList<>();
        Long[] companyIds = companyService.getCompanyIds(1L);
        for(Long companyId:companyIds){
            PowerWaterAndCompanyVo powerWaterAndCompanyVo = new PowerWaterAndCompanyVo();

            //设置公司名称
            powerWaterAndCompanyVo.setCompanyName(companyService.getCompanyNameById(companyId));

            //设置电表读数
            Long[] powerIds = powerService.getPowerIds(companyId);
            Double powerValue = 0D;
            for(Long powerId:powerIds){
                powerValue += powerService.getPowerToday(powerId);
            }
            if (powerValue == 0D){
                powerWaterAndCompanyVo.setPowerValue(0D);
            }else {
                Double lastPowerValue = 0D;
                for(Long powerId:powerIds){
                    lastPowerValue += powerService.getPowerLastOneYesterday(powerId);
                }
                powerWaterAndCompanyVo.setPowerValue(powerValue-lastPowerValue);
            }

            //设置水表读数
            Long[] waterIds = waterService.getWaterIds(companyId);
            Double waterValue = 0D;
            for(Long waterId:waterIds){
                waterValue += waterService.getWaterToday(waterId);
            }
            if (waterValue == 0D){
                powerWaterAndCompanyVo.setWaterValue(0D);
            }else {
                Double lastWaterValue = 0D;
                for(Long waterId:waterIds){
                    lastWaterValue += waterService.getWaterLastOneYesterday(waterId);
                }
                powerWaterAndCompanyVo.setPowerValue(powerValue-lastWaterValue);
            }
            powerWaterAndCompanyVos.add(powerWaterAndCompanyVo);
        }
        return powerWaterAndCompanyVos;
    }
}

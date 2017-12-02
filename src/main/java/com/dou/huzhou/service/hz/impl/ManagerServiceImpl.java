package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.ManagerDao;
import com.dou.huzhou.domain.hz.EnergyConsumptionDo;
import com.dou.huzhou.domain.hz.EnergyConsumptionVo;
import com.dou.huzhou.service.hz.CompanyService;
import com.dou.huzhou.service.hz.ManagerService;
import com.dou.huzhou.service.hz.PowerService;
import com.dou.huzhou.utils.hz.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 9:35
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
    private final static Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);


    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PowerService powerService;

    @Override
    public EnergyConsumptionDo getToadyEnergyConsumptionById(Long powerId) {
        EnergyConsumptionDo energyConsumptionDo = null;
        try {
            energyConsumptionDo = managerDao.getToadyEnergyConsumptionById(powerId);
        }catch (Exception e){
            LOGGER.error(" getToadyEnergyConsumptionById failed. ");
        }
        if(energyConsumptionDo == null){
            energyConsumptionDo = new EnergyConsumptionDo();
            energyConsumptionDo.setVoltage(0D);
            energyConsumptionDo.setElectricity(0D);
            energyConsumptionDo.setActivePower(0D);
            energyConsumptionDo.setTotalPower(0D);
            energyConsumptionDo.setPowerFactor(0D);
            energyConsumptionDo.setTotalPowerFactor(0D);
            energyConsumptionDo.setTotalActiveEnergy(0D);
            energyConsumptionDo.setPowerfulTipEnergy(0D);
            energyConsumptionDo.setPowerfulPeakEnergy(0D);
            energyConsumptionDo.setPowerfulValleyEnergy(0D);
            energyConsumptionDo.setRate(1D);
            energyConsumptionDo.setTime(TimeUtil.getZeroTimeToady());
        }
        return energyConsumptionDo;
    }


    @Override
    public List<EnergyConsumptionVo> getEnergyList() {
        List<EnergyConsumptionVo> energyConsumptionVos = new ArrayList<>();
        Long[] companyIds = companyService.getCompanyIds(1L);
        for(Long companyId:companyIds){
            EnergyConsumptionVo energyConsumptionVo = new EnergyConsumptionVo();
            energyConsumptionVo.setCompanyName(companyService.getCompanyNameById(companyId));

            List<EnergyConsumptionDo> temp = new ArrayList<>();
            Long[] powerIds = powerService.getPowerIds(companyId);
            for(Long powerId:powerIds){
                EnergyConsumptionDo toadyEnergyConsumptionById = getToadyEnergyConsumptionById(powerId);
                temp.add(toadyEnergyConsumptionById);
            }
            Collections.sort(temp);
            //设置最新值
            EnergyConsumptionDo energyConsumptionDo = temp.get(0);
            energyConsumptionVo.setVoltage(energyConsumptionDo.getVoltage());
            energyConsumptionVo.setElectricity(energyConsumptionDo.getElectricity());
            energyConsumptionVo.setActivePower(energyConsumptionDo.getActivePower());
            energyConsumptionVo.setTotalPower(energyConsumptionDo.getTotalPower());
            energyConsumptionVo.setPowerFactor(energyConsumptionDo.getPowerFactor());
            energyConsumptionVo.setTotalPowerFactor(energyConsumptionDo.getTotalPowerFactor());

            energyConsumptionVo.setRate(energyConsumptionDo.getRate());
            energyConsumptionVo.setTime(energyConsumptionDo.getTime());

            energyConsumptionVo.setTotalActiveEnergy(0D);
            energyConsumptionVo.setPowerfulTipEnergy(0D);
            energyConsumptionVo.setPowerfulPeakEnergy(0D);
            energyConsumptionVo.setPowerfulValleyEnergy(0D);
            //设置总和值
            for(EnergyConsumptionDo energyConsumptionDo1:temp){

                energyConsumptionVo.setTotalActiveEnergy(energyConsumptionDo1.getTotalActiveEnergy() + energyConsumptionVo.getTotalActiveEnergy());
                energyConsumptionVo.setPowerfulTipEnergy(energyConsumptionDo1.getPowerfulTipEnergy()+energyConsumptionVo.getPowerfulTipEnergy());
                energyConsumptionVo.setPowerfulPeakEnergy(energyConsumptionDo1.getPowerfulPeakEnergy()+energyConsumptionVo.getPowerfulPeakEnergy());
                energyConsumptionVo.setPowerfulValleyEnergy(energyConsumptionDo1.getPowerfulValleyEnergy()+energyConsumptionVo.getPowerfulValleyEnergy());
            }
            energyConsumptionVos.add(energyConsumptionVo);
        }
        return energyConsumptionVos;
    }
}

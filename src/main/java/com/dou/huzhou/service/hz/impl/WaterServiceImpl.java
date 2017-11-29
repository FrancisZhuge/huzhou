package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.WaterDao;
import com.dou.huzhou.domain.hz.WaterDo;
import com.dou.huzhou.service.hz.WaterService;
import com.dou.huzhou.utils.hz.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:56
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class WaterServiceImpl implements WaterService{
    private final static Logger LOGGER = LoggerFactory.getLogger(WaterServiceImpl.class);

    @Autowired
    private WaterDao waterDao;
    @Override
    public Long[] getWaterIds(Long companyId) {
        Long[] ids = null;
        try {
            ids = waterDao.getWaterIds(companyId);
        } catch (Exception e) {
            LOGGER.error("getWaterIds failed. ");
        }
        return ids;
    }

    @Override
    public Double getLastValue(Long id) {
        Double value = null;
        try {
            value = waterDao.getLastValue(id);
        } catch (Exception e) {
            LOGGER.error("getLastValue failed.");
        }
        return value;
    }

    @Override
    public Double getLastMonthValue(Long id) {
        Double value = null;
        try {
            value = waterDao.getLastMouthValue(id,TimeUtil.getLastMonthLastDay());
        } catch (Exception e) {
            LOGGER.error("getLastMonthValue failed.");
        }
        if(value == null){
            return 0D;
        }
        return value;
    }

    @Override
    public List<WaterDo> getWaterPerHour(Long waterId) {
        List<WaterDo> waterDos = null;
        try {
            waterDos = waterDao.getWaterPerHour(waterId);
        } catch (Exception e) {
            LOGGER.error("getWaterPerHour failed.");
        }
        return waterDos;
    }

    @Override
    public double getWaterLastOneYesterday(Long waterId) {
        Double value = null;
        try {
            value = waterDao.getWaterLastOneYesterday(waterId);
        } catch (Exception e) {
            LOGGER.error("getWaterLastOneYesterday failed.");
        }
        if (value==null){
            return 0D;
        }
        return value;
    }

    @Override
    public List<WaterDo> getWaterPerDay(Long waterId) {
        List<WaterDo> waterDos = null;
        try {
            waterDos = waterDao.getWaterPerDay(waterId);
        } catch (Exception e) {
            LOGGER.error("getWaterPerDay failed.");
        }
        return waterDos;
    }

    @Override
    public List<WaterDo> getWaterByPercentage(int day, Long waterId) {
        List<WaterDo> waterDos = null;
        try {
            waterDos = waterDao.getWaterByPercentage(day,waterId);
        } catch (Exception e) {
            LOGGER.error("getWaterByPercentage failed.");
        }
        return waterDos;
    }

    @Override
    public Double getWaterLastOneYesterday(int day, Long waterId) {
        Double value = null;
        String time = TimeUtil.getTimeByDay(day);
        try {
            value = waterDao.getWaterLastOneYesterdayByDay(time,waterId);
        } catch (Exception e) {
            LOGGER.error("getWaterLastOneYesterday failed.");
        }
        if (value==null){
            return 0D;
        }
        return value;
    }
}

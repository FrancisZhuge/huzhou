package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.WaterDao;
import com.dou.huzhou.domain.hz.WaterDo;
import com.dou.huzhou.service.hz.WaterService;
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
            value = waterDao.getLastMouthValue(id);
        } catch (Exception e) {
            LOGGER.error("getLastMonthValue failed.");
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
}

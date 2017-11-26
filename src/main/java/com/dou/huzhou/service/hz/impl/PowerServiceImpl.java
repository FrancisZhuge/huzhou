package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.PowerDao;
import com.dou.huzhou.service.hz.PowerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:46
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class PowerServiceImpl implements PowerService{
    private static final Logger LOGGER = LoggerFactory.getLogger(PowerServiceImpl.class);

    @Autowired
    private PowerDao powerDao;


    @Override
    public Long[] getPowerIds(Long companyId) {
        Long[] ids = null;
        try {
            ids = powerDao.getPowerIds(companyId);
        } catch (Exception e) {
            LOGGER.error("getPowerIds failed.");
        }
        return ids;
    }

    @Override
    public Double getLastValue(Long id) {
        Double value = null;
        try {
            value = powerDao.getLastValue(id);
        } catch (Exception e) {
            LOGGER.error("getLastValue failed.");
        }
        return value;
    }

    @Override
    public Double getLastMonthValue(Long id) {
        Double value = null;
        try {
            value = powerDao.getLastMouthValue(id);
        } catch (Exception e) {
            LOGGER.error("getLastMonthValue failed.");
        }
        return value;
    }
}

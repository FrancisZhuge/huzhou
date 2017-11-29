package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.PowerDao;
import com.dou.huzhou.domain.hz.PeakAndVallyDo;
import com.dou.huzhou.domain.hz.PowerDo;
import com.dou.huzhou.service.hz.PowerService;
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
            value = powerDao.getLastMouthValue(id,TimeUtil.getLastMonthLastDay());
        } catch (Exception e) {
            LOGGER.error("getLastMonthValue failed.");
        }
        if(value == null)
            return 0D;
        return value;
    }

    @Override
    public List<PowerDo> getPowerPerHour(Long powerId) {
        List<PowerDo> powerDos = null;
        try {
            powerDos = powerDao.getPowerPerHour(powerId);
        } catch (Exception e) {
            LOGGER.error("getPowerPerHour failed.");
        }
        return powerDos;
    }

    @Override
    public double getPowerLastOneYesterday(Long powerId) {
        Double value = null;
        try {
            value = powerDao.getPowerLastOneYesterday(powerId);
        } catch (Exception e) {
            LOGGER.error("getPowerLastOneYesterday failed.");
        }
        if (value == null){
            return 0D;
        }
        return value;
    }

    @Override
    public List<PowerDo> getPowerPerDay(Long powerId) {
        List<PowerDo> powerDos = null;
        try {
            powerDos = powerDao.getPowerPerDay(powerId);
        } catch (Exception e) {
            LOGGER.error("getPowerPerDay failed.");
        }
        return powerDos;
    }

    @Override
    public List<PowerDo> getPowerByPercentage(int day, Long powerId) {
        List<PowerDo> powerDos = null;
        try {
            powerDos = powerDao.getPowerByPercentage(day,powerId);
        } catch (Exception e) {
            LOGGER.error("getPowerByPercentage failed.");
        }
        return powerDos;
    }

    @Override
    public Double getPowerLastOneYesterday(int day, Long powerId) {
        Double value = null;
        String time = TimeUtil.getTimeByDay(day);
        try {
            value = powerDao.getPowerLastOneYesterdayByDay(time,powerId);
        } catch (Exception e) {
            LOGGER.error("getPowerLastOneYesterday failed.");
        }
        if (value==null){
            return 0D;
        }
        return value;
    }

    @Override
    public List<PeakAndVallyDo> getPeakAndVally(int year, int month, Long powerId) {
        List<PeakAndVallyDo> peakAndVallyDos = null;
        try {
            peakAndVallyDos = powerDao.getPeakAndVally(year,month,powerId);
        } catch (Exception e) {
            LOGGER.error("getPeakAndVally failed.");
        }
        return peakAndVallyDos;
    }

    @Override
    public PeakAndVallyDo getLastMonthPeakAndVally(int year, int month, Long powerId) {
        PeakAndVallyDo peakAndVallyDo = null;
        try {
            peakAndVallyDo = powerDao.getLastMonthPeakAndVally(TimeUtil.getFirstDayByYearMonthy(year,month),powerId);
        } catch (Exception e) {
            LOGGER.error("getLastMonthPeakAndVally failed.");
        }
        if (peakAndVallyDo == null){
            peakAndVallyDo = new PeakAndVallyDo();
            peakAndVallyDo.setTip(0D);
            peakAndVallyDo.setPeak(0D);
            peakAndVallyDo.setVally(0D);
        }
        return peakAndVallyDo;
    }

    @Override
    public Double getPowerLastOneAtTime(Long powerId,String time) {
        Double value = null;
        try {
            value = powerDao.getPowerLastOneAtTime(powerId,time);
        } catch (Exception e) {
            LOGGER.error("getPowerLastOneByLastWeek failed.");
        }
        if(value == null)
            value = 0D;
        return value;
    }
}

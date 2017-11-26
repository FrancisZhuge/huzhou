package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.BuildingDao;
import com.dou.huzhou.service.hz.BuildingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 19:33
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class BuildingServiceImpl implements BuildingService{
    private final static Logger LOGGER = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private BuildingDao buildingDao;

    @Override
    public String getBuildingNo(Long id) {
        String returnValue = null;
        String areaNo = null;
        try {
            areaNo = buildingDao.getBuildingNo(id);
        } catch (Exception e) {
            LOGGER.error("getBuildingNo failed. ");
        }
        return areaNo;
    }
}

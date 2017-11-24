package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.CompanyDao;
import com.dou.huzhou.service.hz.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 19:34
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyServiceImpl implements CompanyService{
    private final static Logger LOGGER = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private CompanyDao CompanyDao;

    @Override
    public String getCompanyNo(Long id) {
        String returnValue = null;
        String areaNo = null;
        try {
            areaNo = CompanyDao.getCompanyNo(id);
        } catch (Exception e) {
            LOGGER.error("getBuildingNo failed. ");
        }
        return areaNo;
    }
}

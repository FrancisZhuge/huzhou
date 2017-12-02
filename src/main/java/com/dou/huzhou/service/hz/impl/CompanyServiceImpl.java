package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.CompanyDao;
import com.dou.huzhou.domain.hz.Company;
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
@Transactional
public class CompanyServiceImpl implements CompanyService{
    private final static Logger LOGGER = LoggerFactory.getLogger(BuildingServiceImpl.class);

    @Autowired
    private CompanyDao companyDao;

    @Override
    public String getCompanyNo(Long id) {
        String returnValue = null;
        String areaNo = null;
        try {
            areaNo = companyDao.getCompanyNo(id);
        } catch (Exception e) {
            LOGGER.error("getBuildingNo failed. ");
        }
        return areaNo;
    }

    @Override
    public Company getById(Long id) {
        Company returnValue = null;
        try {
            returnValue = companyDao.getById(id);
        } catch (Exception e) {
            LOGGER.error("getById failed. ");
        }
        return returnValue;
    }

    @Override
    public Long[] getCompanyIds(Long areaId) {
        Long[] companyIds = null;
        try {
            companyIds = companyDao.getCompanyIds(areaId);
        } catch (Exception e) {
            LOGGER.error("getCompanyIds failed. ");
        }
        return companyIds;
    }

    @Override
    public String getCompanyNameById(Long id) {
        String companyName = null;
        try {
            companyName = companyDao.getCompanyNameById(id);
        } catch (Exception e) {
            LOGGER.error("getCompanyNameById failed. ");
        }
        return companyName;
    }
}

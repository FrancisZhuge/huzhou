package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.AreaDao;
import com.dou.huzhou.service.hz.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:39
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional(rollbackFor =Exception.class)
public class AreaServiceImpl implements AreaService{

    private final static Logger LOGGER = LoggerFactory.getLogger(AreaServiceImpl.class);

    @Autowired
    private AreaDao areaDao;

    @Override
    public String getAreaNo(Long id) {
        String returnValue = null;
        String areaNo = null;
        try {
            areaNo = areaDao.getAreaNo(id);
        } catch (Exception e) {
            LOGGER.error("getAreaNo failed. ");
        }
        return areaNo;
    }
}

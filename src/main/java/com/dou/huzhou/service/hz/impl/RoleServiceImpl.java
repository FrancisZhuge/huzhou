package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.service.hz.AreaService;
import com.dou.huzhou.service.hz.BuildingService;
import com.dou.huzhou.service.hz.CompanyService;
import com.dou.huzhou.service.hz.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:26
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService{
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private AreaService areaService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private CompanyService companyService;

    @Override
    public String spellAdminRole(UserInfo user) {
        if(user.getAreaId()==null){
            LOGGER.debug("spellAdminRole role = admin");
            return "admin";
        }else if (user.getBuildingId() == null){
            String areaNo = areaService.getAreaNo(user.getAreaId());
            String returnValue = areaNo+".admin";
            LOGGER.debug("spellAdminRole role = {}",returnValue);
            return returnValue;
        }else if (user.getCompanyId() == null){
            String areaNo = areaService.getAreaNo(user.getAreaId());
            String buildingNo = buildingService.getBuildingNo(user.getBuildingId());
            String returnValue = areaNo+"."+buildingNo+".admin";
            LOGGER.debug("spellAdminRole role = {}",returnValue);
            return returnValue;
        }else{
            String areaNo = areaService.getAreaNo(user.getAreaId());
            String buildingNo = buildingService.getBuildingNo(user.getBuildingId());
            String companyNo = companyService.getCompanyNo(user.getCompanyId());
            String returnValue = areaNo+"."+buildingNo+"."+companyNo + ".admin";
            LOGGER.debug("spellAdminRole role = {}",returnValue);
            return returnValue;
        }
    }
}

package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.dao.hz.MonitorDao;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.MonitorService;
import com.dou.huzhou.service.hz.RoleService;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 15:24
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional
public class MonitorServiceImpl implements MonitorService{
    private final static Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);

    @Autowired
    private MonitorDao monitorDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public List<BuildingCompanyVo> getInfo(Subject user) {
        UserInfo userInfo = userService.getByUsername((String) user.getPrincipal());
        List<BuildingCompanyVo> buildingCompanyVos = null;
        if(userInfo.getAreaId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有admin权限
                //取出所有值
                //todo：这里直接使用了1L，等待改进
                buildingCompanyVos = getInfoByArea(1l);
            }
        }else if(userInfo.getCompanyId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.admin权限
                //取出所有值
                buildingCompanyVos = getInfoByArea(userInfo.getAreaId());
            }
        }else {
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.{company}.admin权限
                //取出该公司的所有值
                buildingCompanyVos = getInfoByCompany(userInfo.getAreaId(), userInfo.getCompanyId());
            }else{
                //没有权限
                //返回空
            }
        }
        return buildingCompanyVos;
    }

    @Override
    public List<BuildingCompanyVo> getInfoByArea(Long areaId) {
        List<BuildingCompanyVo> buildingCompanyVos = null;
        try {
            buildingCompanyVos = monitorDao.getInfoByArea(areaId);
        } catch (Exception e) {
            LOGGER.error("getInfoByArea dao failed");
        }
        return buildingCompanyVos;
    }

    @Override
    public List<BuildingCompanyVo> getInfoByCompany(Long areaId, Long companyId) {
        List<BuildingCompanyVo> buildingCompanyVos = null;
        try {
            buildingCompanyVos = monitorDao.getInfoByCompany(areaId,companyId);
        } catch (Exception e) {
            LOGGER.error("getInfoByCompany dao failed");
        }
        return buildingCompanyVos;
    }
}

package com.dou.huzhou.service.hz.impl;

import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.MapService;
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
 * @Date: Created in 2017/11/24, 14:13
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MapServiceImpl implements MapService{
    private final static Logger LOGGER = LoggerFactory.getLogger(MapServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public List<MapVo> getMapInfo(Subject user) {
        UserInfo userInfo = userService.getByUsername((String) user.getPrincipal());
        if(userInfo.getAreaId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有admin权限
                //取出所有值
                //todo:
            }
        }else if(userInfo.getBuildingId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.admin权限
                //取出所有值
                //todo
            }
        }else if(userInfo.getCompanyId() == null){
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.{building}.admin权限
                //取出该楼的所有值
                //todo
            }
        }else{
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.{building}.{company}.admin权限
                //取出该公司的所有值
                //todo
            }else{
                //没有权限
                //返回空
            }
        }
        return null;
    }

    @Override
    public List<MapVo> getMapInfoByArea(Long areaId) {
        List<MapVo> returnValue = null;
        //todo
        return null;
    }
}

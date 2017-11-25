package com.dou.huzhou.service.hz.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dou.huzhou.dao.hz.MapDao;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.MapService;
import com.dou.huzhou.service.hz.PowerService;
import com.dou.huzhou.service.hz.RoleService;
import com.dou.huzhou.service.hz.WaterService;
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
    private MapDao mapDao;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private WaterService waterService;

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
        JSONArray returnJson = new JSONArray();
        List<MapVo> mapVos = null;
        try {
            mapVos = mapDao.getMapInfoByArea(areaId);
        } catch (Exception e) {
            LOGGER.error("getMapInfoByArea dao failed. ");
        }
        for(MapVo mapVo:mapVos){
            //设置电表值
            Long[] powerIds = powerService.getPowerIds(mapVo.getCompanyId());
            if()
            Double lastValue = 0D;
            for(int i=0;i<)
            if(lastValue == null){
                mapVo.setPowerValue(0D);
            }else {
                Double lastMonthValue = powerService.getLastMonthValue(powerIds[0]);
                if(lastMonthValue == null){
                    mapVo.setPowerValue(lastValue);
                }else {
                    mapVo.setPowerValue(lastValue-lastMonthValue);
                }
            }
            //设置水表值
            Long[] waterIds = waterService.getWaterIds(mapVo.getCompanyId());
            waterService.getLastValue(waterIds[0]);

        }
        return null;
    }
}

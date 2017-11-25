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
        }else{
            if(user.hasRole(roleService.spellAdminRole(userInfo))){
                //拥有{area}.{company}.admin权限
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
        List<MapVo> mapVos = null;
        try {
            mapVos = mapDao.getMapInfoByArea(areaId);
        } catch (Exception e) {
            LOGGER.error("getMapInfoByArea dao failed");
        }
        //设置电表
        for(MapVo mapVo:mapVos){
            Long[] powerIds = powerService.getPowerIds(mapVo.getCompanyId());
            if(powerIds.length==0){
                mapVo.setPowerValue(0D);
                continue;
            }
            Double powerValue = 0D;
            for(int i=0;i<powerIds.length;i++){
                //获取最新读数
                Double lastValue = powerService.getLastValue(powerIds[i]);
                if(lastValue == null){
                    powerValue += 0D;
                }else{
                    powerValue += lastValue;
                }

                if(powerValue == 0D){
                    mapVo.setPowerValue(0D);
                }else {
                    Double powerMonthValue = 0D;
                    Double lastMonthValue = powerService.getLastMonthValue(powerIds[i]);
                    if(lastMonthValue == null){
                        powerMonthValue += 0D;
                    }else {
                        powerMonthValue += lastMonthValue;
                    }
                    mapVo.setPowerValue(powerValue - powerMonthValue);
                }
            }
        }
        //设置水表
        for(MapVo mapVo:mapVos){
            Long[] waterIds = waterService.getWaterIds(mapVo.getCompanyId());
            if(waterIds.length==0){
                mapVo.setWaterValue(0D);
                continue;
            }
            Double waterValue = 0D;
            for(int i=0;i<waterIds.length;i++){
                //获取最新读数
                Double lastValue = waterService.getLastValue(waterIds[i]);
                if(lastValue == null){
                    waterValue += 0D;
                }else{
                    waterValue += lastValue;
                }

                if(waterValue == 0D){
                    mapVo.setWaterValue(0D);
                }else {
                    Double waterMonthValue = 0D;
                    Double lastMonthValue = waterService.getLastMonthValue(waterIds[i]);
                    if(lastMonthValue == null){
                        waterMonthValue += 0D;
                    }else {
                        waterMonthValue += lastMonthValue;
                    }
                    mapVo.setPowerValue(waterValue - waterMonthValue);
                }
            }
        }
        return mapVos;
    }
}

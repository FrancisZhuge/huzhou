package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.domain.hz.PowerAndWaterVo;
import com.dou.huzhou.service.hz.MonitorService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description: 实时监控
 * @Date: Created in 2017/11/26, 14:59
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/hz/monitor")
public class MonitorController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private MonitorService monitorService;

    /**
     * 返回当前用户有权限的公司所在大楼和公司的名称
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public String getInfo(){
        Subject curUser = SecurityUtils.getSubject();
        List<BuildingCompanyVo> mapInfo = null;
        try {
            mapInfo = monitorService.getInfo(curUser);
        } catch (Exception e) {
            LOGGER.error("getMapInfo failed. ");
            return ResponseUtil.responmseServerError();
        }
        LOGGER.debug("getMapInfo success. ");
        return ResponseUtil.responseOkWithData(mapInfo);
    }

    /**
     * 返回今天water和power每隔一小时的用量
     * @param id 公司的id
     * @return
     */
    @RequestMapping("/powerAndWater")
    @ResponseBody
    public String getPowerAndWaterPerHour(@RequestParam(value = "id", required = false) Long id){
        //参数错误
        if (id == null||id ==0L){
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {
            powerAndWaterVos = monitorService.getPowerAndWaterValue(id);
        } catch (Exception e) {
            LOGGER.error("getPowerAndWaterPerHour failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }

    /**
     * 公司当月能耗
     * @param id  公司id
     * @return
     */
    @RequestMapping("/calendar")
    @ResponseBody
    public String calendar(@RequestParam(value = "id", required = false) Long id){
        //参数错误
        if (id == null||id ==0L){
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {
            powerAndWaterVos = monitorService.getPowerAndWaterValuePerDay(id);
        } catch (Exception e) {
            LOGGER.error("calendar failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }

    /**
     * 分时能耗
     * @param id  公司id
     * @param time  选定日期，只用传递日即可，比如1号传递1,2号传递2
     * @return
     */
    @RequestMapping("/percentage")
    @ResponseBody
    public String percentage(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "time",required = false) Integer time){
        //参数错误
        if (id == null||id ==0L){
            return ResponseUtil.responseIllegalArgus();
        }
        if (time == null||time<1||time>31){
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {

        }catch (Exception e) {
            LOGGER.error("percentage failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }
}

package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.domain.hz.PeakAndVallyVo;
import com.dou.huzhou.domain.hz.PowerAndWaterVo;
import com.dou.huzhou.service.hz.MonitorService;
import com.dou.huzhou.utils.hz.TimeUtil;
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
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {
            powerAndWaterVos = monitorService.getPowerAndWaterPerHour(id);
        } catch (Exception e) {
            LOGGER.error("getPowerAndWaterPerHour failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }

    /**
     * 返回主键为{id}的公司当月每天的能耗
     * @param id  公司id
     * @return
     */
    @RequestMapping("/calendar")
    @ResponseBody
    public String calendar(@RequestParam(value = "id", required = false) Long id){
        //参数错误
        if (id == null||id ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {
            powerAndWaterVos = monitorService.getPowerAndWaterPerDay(id);
        } catch (Exception e) {
            LOGGER.error("calendar failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }

    /**
     * 当月分时能耗
     * @param id  公司id
     * @param time  选定日期，只用传递日即可，比如1号传递1,2号传递2
     * @return
     */
    //todo：可以将日期修改的更加完美些

    @RequestMapping("/percentage")
    @ResponseBody
    public String percentage(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam(value = "time",required = false) Integer time){
        //参数错误
        if (id == null||id ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        if (time == null||time<1||time>31){
            LOGGER.error("params over range. 1<day<=31, but day={}",time);
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerAndWaterVo> powerAndWaterVos = null;
        try {
            powerAndWaterVos = monitorService.getPowerAndWaterValueByPercentage(time,id);
        }catch (Exception e) {
            LOGGER.error("percentage failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerAndWaterVos);
    }

    /**
     *
     * @param year 年，输入样式 2017
     * @param month 月，输入样式 12
     * @param id 企业id
     * @return
     */
    @RequestMapping("/peakAndVally")
    @ResponseBody
    public String peakAndVally(@RequestParam(value = "year",required = false) Integer year,
                               @RequestParam(value = "month",required = false) Integer month,
                               @RequestParam(value = "id",required = false) Long id ){
        //参数错误
        if(month!=null&&month!=0){
            if(month>12||month<1){
                LOGGER.error("params over range. 1<=month<=12, but month = {}",month);
                return ResponseUtil.responseIllegalArgus();
            }
        }
        if(year!=0&&year!=null){
            if(year<0||year> TimeUtil.getCurrentYear()){
                LOGGER.error("params over range. 1<=year<={}, but year = {}",TimeUtil.getCurrentYear(),year);
                return ResponseUtil.responseIllegalArgus();
            }
        }
        if (id == null||id ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        //默认当月
        if(month == null || month==0){
            month = TimeUtil.getCurrentMonth();
        }
        //默认当年
        if(year == null || year==0){
            year = TimeUtil.getCurrentYear();
        }

        List<PeakAndVallyVo> peakAndVallyVos = null;
        try {
            peakAndVallyVos = monitorService.getPeakAndVally(year,month,id);
        }catch (Exception e) {
            LOGGER.error("peakAndVally failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(peakAndVallyVos);

    }
}

package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.PowerPeakAndVallyVo;
import com.dou.huzhou.domain.hz.PowerVo;
import com.dou.huzhou.service.hz.AnalysisService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/28, 23:36
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@RequestMapping("/hz/analysis")
public class AnalysisController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AnalysisController.class);

    @Autowired
    private AnalysisService analysisService;

    /**
     * 用电状态及趋势
     * @param companyId
     * @return
     */
    @RequestMapping("/currentWeek")
    @ResponseBody
    public String currentWeek(@RequestParam(value = "companyId",required = false) Long companyId){
        //参数错误
        if (companyId == null||companyId ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerVo> powerVos = null;
        try {
            powerVos = analysisService.getCurrentWeek(companyId);
        }catch (Exception e) {
            LOGGER.error("currentWeek failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerVos);
    }

    /**
     * 企业能耗统计
     */
    @RequestMapping("/energyConsumption")
    @ResponseBody
    public String energyConsumption(@RequestParam(value = "companyId",required = false) Long companyId){
        //参数错误
        if (companyId == null||companyId ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerPeakAndVallyVo> powerPeakAndVallyVos = null;
        try {
            powerPeakAndVallyVos = analysisService.getEnergyConsumption(companyId);
        }catch (Exception e) {
            LOGGER.error("energyConsumption failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerPeakAndVallyVos);
    }

    /**
     * 今年 按月用电量
     */
    @RequestMapping("/energyByMonth")
    @ResponseBody
    public String energyByMonth(@RequestParam(value = "companyId",required = false) Long companyId){
        //参数错误
        if (companyId == null||companyId ==0L){
            LOGGER.error("missing params. companyId = null");
            return ResponseUtil.responseIllegalArgus();
        }
        List<PowerVo> powerVos = null;
        try {
            powerVos = analysisService.getEnergyByMonth(companyId);
        }catch (Exception e) {
            LOGGER.error("energyByMonth failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerVos);
    }
}

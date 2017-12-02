package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.PowerWaterAndCompanyVo;
import com.dou.huzhou.service.hz.StatisticsService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description: 能耗大屏
 * @Date: Created in 2017/11/30, 12:05
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/hz/statistics")
public class StatisticsController {
    public final static Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);

    @Autowired
    private StatisticsService statisticsService;

    /**
     * 获取当前所有能耗的总和
     * @return
     */
    @RequestMapping("/getCoal")
    @ResponseBody
    public String getCoal(){
        Double coal = null;
        try {
            coal = statisticsService.getCoal();
        } catch (Exception e) {
            LOGGER.error("getCoal failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(coal);
    }

    /**
     * 获得有序的电力和水力集合
     *  companyName
     *  powerValue
     *  waterValue
     * @return
     */
    @RequestMapping("/powerAndWaterByOrder")
    @ResponseBody
    public String getPowerAndWaterByOrder(){
        List<PowerWaterAndCompanyVo> powerWaterAndCompanyVos = null;
        try {
            powerWaterAndCompanyVos = statisticsService.getPowerAndWaterByOrder();
            Collections.sort(powerWaterAndCompanyVos);
        } catch (Exception e) {
            LOGGER.error("getPowerAndWaterByOrder failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerWaterAndCompanyVos);
    }
}

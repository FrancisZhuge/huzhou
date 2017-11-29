package com.dou.huzhou.web.controller.hz;

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
            LOGGER.error("percentage failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(powerVos);

    }
}

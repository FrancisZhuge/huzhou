package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.EnergyConsumptionVo;
import com.dou.huzhou.service.hz.ManagerService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 9:33
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/hz/manage")
public class MangerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MangerController.class);

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/energyList")
    @ResponseBody
    public String getEnergyList(){
        List<EnergyConsumptionVo> energyList = null;
        try {
            energyList = managerService.getEnergyList();
        } catch (Exception e) {
            LOGGER.error("getEnergyList failed. ");
            return ResponseUtil.responmseServerError();
        }
        return ResponseUtil.responseOkWithData(energyList);
    }
}

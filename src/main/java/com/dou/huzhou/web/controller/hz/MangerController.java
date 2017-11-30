package com.dou.huzhou.web.controller.hz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/energyList")
    @ResponseBody
    public String getEnergyList(){

    }
}

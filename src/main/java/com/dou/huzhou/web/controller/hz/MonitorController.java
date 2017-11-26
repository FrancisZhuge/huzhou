package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.service.hz.MonitorService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

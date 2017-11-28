package com.dou.huzhou.web.controller.hz;

import com.dou.huzhou.domain.HostHolder;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.service.hz.MapService;
import com.dou.huzhou.web.response.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 13:52
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Controller
@RequestMapping("/hz/map")
public class MapController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MapController.class);

    @Autowired
    private MapService mapService;

    /**
     * 获取湖州{mapInfo}信息
     * @return
     */
    @RequestMapping("/mapInfo")
    public String getMapInfo(){
        Subject curUser = SecurityUtils.getSubject();
        List<MapVo> mapInfo = null;
        try {
            mapInfo = mapService.getMapInfo(curUser);
        } catch (Exception e) {
            LOGGER.error("getMapInfo failed. ");
            return ResponseUtil.responmseServerError();
        }
        LOGGER.debug("getMapInfo success. ");
        return ResponseUtil.responseOkWithData(mapInfo);
    }
}

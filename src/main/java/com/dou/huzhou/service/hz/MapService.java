package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.MapVo;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 14:01
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface MapService {

    /**
     * 根据用户获得对应权限的相应数据
     * @param user
     * @return
     */
    List<MapVo> getMapInfo(Subject user);

    /**
     * 根据areaId来获取整个园区的所有Map信息
     * @param areaId
     * @return
     */
    List<MapVo> getMapInfoByArea(Long areaId);

    /**
     * 根据areadId和companyId来获取指定公司的Map信息
     * @param areaId
     * @param companyId
     * @return
     */
    List<MapVo> getMapInfoByCompany(Long areaId, Long companyId);


}

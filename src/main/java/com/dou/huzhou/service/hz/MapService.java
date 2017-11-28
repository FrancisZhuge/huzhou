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
     * 根据相应的用户
     * 获取该用户相应权限的{MapVo}
     * @param user 用户
     * @return
     */
    List<MapVo> getMapInfo(Subject user);

    /**
     * 根据园区的{areaId}来获取该园区的所有{MapVo}信息
     * @param areaId 园区的主键
     * @return
     */
    List<MapVo> getMapInfoByArea(Long areaId);

    /**
     * 根据{areadId}和{companyId}来获取指定园区公司的Map信息
     * @param areaId 园区的主键
     * @param companyId 公司的主键
     * @return
     */
    List<MapVo> getMapInfoByCompany(Long areaId, Long companyId);


}

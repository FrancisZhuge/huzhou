package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.domain.hz.PowerAndWaterVo;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/26, 15:05
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface MonitorService {

    /**
     * 获取大楼和公司对应的名称
     * @param user
     * @return
     */
    List<BuildingCompanyVo> getInfo(Subject user);

    /**
     * 根据areaId来获取整个园区的所有Building和Company信息
     * @param areaId
     * @return
     */
    List<BuildingCompanyVo> getInfoByArea(Long areaId);

    /**
     * 根据areadId和companyId来获取指定公司的所有Building和Company信息
     * @param areaId
     * @param companyId
     * @return
     */
    List<BuildingCompanyVo> getInfoByCompany(Long areaId, Long companyId);

    /**
     * 根据company_id 来获取公司当天的用电情况（每小时，以整点右边最近的时间为整点时间）
     * @param companyId
     * @return
     */
    List<PowerAndWaterVo> getPowerAndWaterValue(Long companyId);
}
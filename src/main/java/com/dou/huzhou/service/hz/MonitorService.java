package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.BuildingCompanyVo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.domain.hz.PeakAndVallyVo;
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

    /**
     * 根据company_id 来获取公司当月的用电情况（每天最后一条数据为准）
     * @param companyId
     * @return
     */
    List<PowerAndWaterVo> getPowerAndWaterValuePerDay(Long companyId);

    /**
     * 根据time和company_id来获取公司的能耗百分比图。
     * @param time 直接使用数字即可，表示日期，比如1号使用1,2号使用2
     * @param companyId
     * @return
     */
    List<PowerAndWaterVo> getPowerAndWaterValueByPercentage(Integer time, Long companyId);

    /**
     * 根据year month 和companyId来获取公司的峰谷能耗
     * @param year 年份，2016 表示2016年
     * @param month 月份，9 表示9月
     * @param companyId 公司的主键
     * @return
     */
    List<PeakAndVallyVo> getPeakAndVally(Integer year, Integer month, Long companyId);
}

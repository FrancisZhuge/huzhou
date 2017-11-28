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
     * 根据{user}获取该用户对应的权限的{BuildingCompanyVo}
     * @param user 当前用户
     * @return
     */
    List<BuildingCompanyVo> getInfo(Subject user);

    /**
     * 根据{areaId}来获取整个园区的所有{BuildingCompanyVo}
     * @param areaId 园区的主键
     * @return
     */
    List<BuildingCompanyVo> getInfoByArea(Long areaId);

    /**
     * 根据{areadId}和{companyId}来获取指定公司的所有{BuildingCompanyVo}
     * @param areaId 园区的主键
     * @param companyId 公司的主键
     * @return
     */
    List<BuildingCompanyVo> getInfoByAreaAndCompany(Long areaId, Long companyId);

    /**
     * 根据{companyId} 来获取公司当天的分时用电和用水情况（每小时，最后一个数值作为这个时间段的结束值）
     * @param companyId 公司的主键
     * @return
     */
    List<PowerAndWaterVo> getPowerAndWaterPerHour(Long companyId);

    /**
     * 根据{companyId} 来获取公司当月的分天用电和用水情况（每天，最后一个数值作为这个时间段的结束值）
     * @param companyId
     * @return
     */
    List<PowerAndWaterVo> getPowerAndWaterPerDay(Long companyId);

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

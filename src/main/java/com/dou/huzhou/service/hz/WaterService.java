package com.dou.huzhou.service.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:55
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface WaterService {
    /**
     * 获取某个公司下面的所有水表
     * @param companyId
     * @return
     */
    Long[] getWaterIds( Long companyId);

    /**
     * 获取指定电表的最新值
     * @param id
     * @return
     *          如果本月没有读数，返回为null
     */
    Double getLastValue(Long id);

    /**
     * 获取上一个月最后一个值
     * @param id
     * @return
     */
    Double getLastMonthValue(Long id);
}
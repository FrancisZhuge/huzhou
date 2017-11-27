package com.dou.huzhou.service.hz;


import com.dou.huzhou.domain.hz.PowerDo;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:45
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface PowerService {
    /**
     * 获取某个公司下面的所有电表
     * @param companyId
     * @return
     */
    Long[] getPowerIds( Long companyId);

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

    /**
     * 根据电表的主键来获取当天的每小时数值
     * @param powerId
     * @return
     */
    List<PowerDo> getPowerPerHour(Long powerId);

    /**
     * 当月每天的电表读数
     * @param powerId
     * @return
     */
    List<PowerDo> getPowerPerDay(Long powerId);

    /**
     * 当天时间power读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param powerId 电表id
     * @return
     */
    List<PowerDo> getPowerByPercentage(int time, Long powerId);

    /**
     * 查找当前天后一天的第一条读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param powerId 电表id
     * @return
     */
    double getTomorrowFirstValue(int time, Long powerId);
}

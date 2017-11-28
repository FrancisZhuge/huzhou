package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.WaterDo;

import java.util.List;

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
     * 获取指定水表的最新值
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
     * 根据水表的主键来获取当天的每小时数值(每个时间段内最大的值作为这个时间段的结束)
     * @param waterId
     * @return
     */
    List<WaterDo> getWaterPerHour(Long waterId);

    /**
     * 获取水表表前一天最后一个读数
     * @param waterId
     * @return
     */
    double getWaterLastOneYesterday(Long waterId);

    /**
     * 当月每天的水表读数
     * @param waterId
     * @return
     */
    List<WaterDo> getWaterPerDay(Long waterId);

    /**
     * 当天时间water读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param waterId 水表id
     * @return
     */
    List<WaterDo> getWaterByPercentage(int time, Long waterId);

    /**
     * 查找当前天后一天的第一条读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param waterId 水表id
     * @return
     */
    double getTomorrowFirstValue(int time, Long waterId);
}

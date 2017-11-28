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
     * 根据水表的主键来获取当月的每天的数值(每个时间段内最后的值作为这个时间段的结束)
     * @param waterId
     * @return
     */
    List<WaterDo> getWaterPerDay(Long waterId);

    /**
     * 返回主键为{id}鼠标在本年本月第（day）日的百分比能耗
     * @param day  日期 整数就行 1号time=1 2号time=2
     * @param waterId 水表id
     * @return
     */
    List<WaterDo> getWaterByPercentage(int day, Long waterId);

    /**
     * 返回主键为{id}水表表在第（day）日的前一天最后一条数据的值
     * @param day
     * @param waterId
     * @return
     */
    Double getWaterLastOneYesterday(int day, Long waterId);

}

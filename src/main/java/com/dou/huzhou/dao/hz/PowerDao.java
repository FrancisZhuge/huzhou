package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.PeakAndVallyDo;
import com.dou.huzhou.domain.hz.PowerDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:39
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface PowerDao {
    String TABLE_POWER_INFO = "power_info";
    String TABLE_POWER_METER_RECORD = "power_meter_record";

    String TIP = "by_kwhj";
    String PEAK = "by_kwhf";
    String VALLY = "by_kwhg";

    /**
     * 返回指定公司所有电表的主键
     * @param companyId
     * @return
     */
    @Select({" select id from ", TABLE_POWER_INFO ," where company_id = #{companyId} "})
    Long[] getPowerIds(@Param("companyId") Long companyId);


    /**
     * 获取指定电表的最新读数
     * @param id
     * @return
     */
    @Select({" select epp from ", TABLE_POWER_METER_RECORD ," where power_info_id = #{id} order by read_time desc limit 0,1"})
    Double getLastValue(@Param("id") Long id);

    /**
     * 获取上个月最后一次记录值
     * @param id
     * @return
     */
    @Select({" SELECT pmr.epp FROM ", TABLE_POWER_INFO ," pi, ", TABLE_POWER_METER_RECORD ," pmr WHERE pi.id = #{id} AND pi.id=pmr.power_info_id AND MONTH(pmr.read_time)=MONTH(NOW())-1 ORDER BY pmr.read_time DESC LIMIT 0,1 "})
    Double getLastMouthValue(@Param("id") Long id);

    /**
     * 每小时power读数
     * @param powerId
     * @return
     */
    @Select({" SELECT HOUR(pmr.read_time) as time, min(pmr.epp) as power_value\n" +
            "FROM", TABLE_POWER_INFO ," pi,", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE pi.id = #{powerId} AND pi.id=pmr.power_info_id AND DAY(pmr.read_time)=DAY(NOW()) GROUP BY time "})
    List<PowerDo> getPowerPerHour(@Param("powerId") Long powerId);

    /**
     * 当月每天power读数
     * @param powerId
     * @return
     */
    @Select({" SELECT Day(pmr.read_time) as time, max(pmr.epp) as power_value FROM ", TABLE_POWER_INFO ," pi, ", TABLE_POWER_METER_RECORD ," pmr WHERE pi.id = #{powerId} AND pi.id=pmr.power_info_id AND MONTH(pmr.read_time)=MONTH(NOW()) GROUP BY time "})
    List<PowerDo> getPowerPerDay(@Param("powerId") Long powerId);

    /**
     * 当天时间power读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param powerId 电表id
     * @return
     */
    @Select({" SELECT HOUR(pmr.read_time) as time, min(pmr.epp) as power_value FROM ", TABLE_POWER_INFO ," pi, ", TABLE_POWER_METER_RECORD ," pmr WHERE pi.id = #{powerId} AND DAY(pmr.read_time) = #{time} AND pi.id=pmr.power_info_id GROUP BY time "})
    List<PowerDo> getPowerByPercentage(@Param("time") int time, @Param("powerId") Long powerId);

    /**
     * 查找当前天后一天的第一条读数
     * 0点读数就是    0点过去的第一个值
     * @param time  日期 整数就行 1号time=1 2号time=2
     * @param powerId 水表id
     * @return
     */
    @Select({" SELECT pmr.epp FROM ", TABLE_POWER_INFO ," pi, ", TABLE_POWER_METER_RECORD ," pmr WHERE pi.id = #{powerId} AND pi.id=pmr.power_info_id AND DAY(pmr.read_time)=#{time}+1 ORDER BY pmr.read_time ASC LIMIT 0,1 "})
    double getTomorrowFirstValue(@Param("time") int time, @Param("powerId") Long powerId);

    /**
     * 根据year month 和powerId来获取某个电表的峰谷能耗
     * @param year 年份，2016 表示2016年
     * @param month 月份，9 表示9月
     * @param powerId 电表的主键
     * @return
     */
    @Select({"  " +
            "SELECT\n" +
            "  day(pmr.read_time) as time,\n" +
            "  min(pmr. ", TIP ," ) as tip,\n" +
            "  min(pmr. ", PEAK ," ) as peak,\n" +
            "  min(pmr. ", VALLY ," ) as vally\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  YEAR(pmr.read_time)=#{year}\n" +
            "AND\n" +
            "  MONTH(pmr.read_time)=#{month}\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<PeakAndVallyDo> getPeakAndVally(
            @Param("year") int year,
            @Param("month") int month,
            @Param("powerId") Long powerId
                                         );

    /**
     * 根据year month 和powerId来获取某个电表下个月第一条的峰谷能耗数据
     * @param year 年份，2016 表示2016年
     * @param month 月份，9 表示9月
     * @param powerId 电表的主键
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  min(pmr. ", TIP ," ) as tip,\n" +
            "  min(pmr. ", PEAK ," ) as peak,\n" +
            "  min(pmr. ", VALLY ," ) as vally\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  YEAR(pmr.read_time)=#{year}\n" +
            "AND\n" +
            "  MONTH(pmr.read_time)=#{month}+1\n" +
            "ORDER BY\n" +
            "  pmr.read_time\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    PeakAndVallyDo getNextMonthPeakAndVally(
            @Param("year") int year,
            @Param("month") int month,
            @Param("powerId") Long powerId
    );
}

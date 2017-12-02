package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.PeakAndVallyDo;
import com.dou.huzhou.domain.hz.PowerDo;
import com.dou.huzhou.domain.hz.PowerPeakAndVallyDo;
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
     * @param companyId 公司的id
     * @return
     */
    @Select({" select id from ", TABLE_POWER_INFO ," where company_id = #{companyId} "})
    Long[] getPowerIds(@Param("companyId") Long companyId);


    /**
     * 获取指定电表{id}的最新读数
     * @param id 电表的id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{id}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getLastValue(@Param("id") Long id);

    /**
     * 获取上个月最后一次记录值
     * @param id 指定电表的id
     * @return
     */
    @Select({" " +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{id}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE(pmr.read_time)<=#{time}\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT \n" +
            "  0,1;" +
            ""})
    Double getLastMouthValue(@Param("id") Long id, @Param("time") String time);

    /**
     * 根据电表的主键来获取当天的每小时数值(每个时间段内最大的值作为这个时间段的结束)
     * @param powerId 电表的主键
     * @return
     */
    @Select({" " +
            "SELECT\n" +
            "  HOUR(pmr.read_time) as time,\n" +
            "  MAX(pmr.epp) as power_value\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE (pmr.read_time)=DATE(now())\n" +
            "GROUP BY\n" +
            "  time;" +
            " "})
    List<PowerDo> getPowerPerHour(@Param("powerId") Long powerId);

    /**
     * 根据电表的主键来获取昨天最后一个读数值
     * @param powerId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE(pmr.read_time)<=date_sub(CURDATE(),INTERVAL 1 DAY)\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getPowerLastOneYesterday(@Param("powerId") Long powerId);

    /**
     * 根据电表的主键来获取当月的每天的数值(每个时间段内最后的值作为这个时间段的结束)
     * @param powerId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  Day(pmr.read_time) as time,\n" +
            "  max(pmr.epp) as power_value\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  YEAR (pmr.read_time)=YEAR(now())\n" +
            "AND\n" +
            "  MONTH (pmr.read_time)=MONTH(now())\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<PowerDo> getPowerPerDay(@Param("powerId") Long powerId);

    /**
     * 返回主键为{id}鼠标在本年本月第（day）日的百分比能耗
     * @param day  日期 整数就行 1号time=1 2号time=2
     * @param powerId 电表id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  Day(pmr.read_time) as time,\n" +
            "  max(pmr.epp) as power_value\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  YEAR (pmr.read_time)=YEAR(now())\n" +
            "AND\n" +
            "  MONTH (pmr.read_time)=MONTH(now())\n" +
            "AND\n" +
            "  DAY(pmr.read_time) = #{day}\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<PowerDo> getPowerByPercentage(@Param("day") int day, @Param("powerId") Long powerId);

    /**
     * 返回主键为{id}电表在time日期指定的前一天最后一条数据的值
     * @param time  日期 2017-01-01
     * @param powerId 电表id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE (pmr.read_time) <= DATE (date_sub(#{time},INTERVAL 1 DAY))\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getPowerLastOneYesterdayByDay(@Param("time") String time,@Param("powerId") Long powerId);

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
            "  max(pmr. ", TIP ," ) as tip,\n" +
            "  max(pmr. ", PEAK ," ) as peak,\n" +
            "  max(pmr. ", VALLY ," ) as vally\n" +
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
     * 根据year month 和powerId来获取某个电表上个月最后一条的峰谷能耗数据
     * @param time 这个月的时间，比如2017-01-01
     * @param powerId 电表的主键
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.", TIP ," as tip,\n" +
            "  pmr.", PEAK ," as peak,\n" +
            "  pmr.", VALLY ," as vally\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "  AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "  AND\n" +
            "  DATE(pmr.read_time)<#{time}\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    PeakAndVallyDo getLastMonthPeakAndVally(
            @Param("time") String time,
            @Param("powerId") Long powerId
    );


    /**
     * 根据电表的{powerId}获取这个电表指定时间之前的最后一条读数
     * @param powerId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  Date(pmr.read_time) <= #{time}\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;\n" +
            ""})
    Double getPowerLastOneAtTime(@Param("powerId") Long powerId,@Param("time") String time);

    /**
     * 获取主键为{powerId}的电表当前时间之前的最后一条的用电情况+尖+峰+谷
     * @param powerId
     * @param time
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.read_time,\n" +
            "  pmr.epp as power_value,\n" +
            "  pmr.", TIP ," as tip,\n" +
            "  pmr.", PEAK ," as peak,\n" +
            "  pmr.", VALLY ," as vally\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE (pmr.read_time)<=#{time}\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    PowerPeakAndVallyDo getPowerPeakAndVallyAtTime(@Param("powerId") Long powerId,@Param("time") String time);

    /**
     * 获取主键为{powerId}的电表当前时间之前的最后一条的用电情况
     * @param powerId
     * @param time
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE (pmr.read_time)<#{time}\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getPowerAtFixedTime(@Param("powerId") Long powerId,@Param("time") String time);

    /**
     * 获取今天的读数
     * @param powerId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.epp\n" +
            "FROM\n" +
            "  ",TABLE_POWER_INFO," pi,\n" +
            "  ",TABLE_POWER_METER_RECORD," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  pi.id=pmr.power_info_id\n" +
            "AND\n" +
            "  DATE (pmr.read_time)=DATE (now())\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getPowerToday(@Param("powerId") Long powerId);

}

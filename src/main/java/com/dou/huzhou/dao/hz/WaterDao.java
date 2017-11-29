package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.WaterDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 9:53
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface WaterDao {
    String TABLE_WATER_INFO = "water_info";
    String TABLE_WATER_METER_RECORD = "water_meter_record";
    /**
     * 返回某个公司所有水表的主键
     * @param companyId
     * @return
     */
    @Select({" select id from ", TABLE_WATER_INFO ," where company_id = #{companyId} "})
    Long[] getWaterIds(@Param("companyId") Long companyId);

    /**
     * 获取指定电表的最新读数
     * @param id
     * @return
     */
    @Select({" select consumption from ", TABLE_WATER_METER_RECORD ," where water_info_id = #{id} order by read_time desc limit 0,1"})
    Double getLastValue(@Param("id") Long id);

    /**
     * 获取上个月最后一次记录值
     * @param id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  wmr.consumption\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{id}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  Date(wmr.read_time)<=#{time}\n" +
            "ORDER BY\n" +
            "  wmr.read_time DESC\n" +
            "LIMIT \n" +
            "  0,1;" +
            ""})
    Double getLastMouthValue(@Param("id") Long id ,@Param("time") String time);

    /**
     * 根据水表的主键来获取当天的每小时数值(每个时间段内最后的值作为这个时间段的结束)
     * @param waterId 水表主键
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  HOUR(wmr.read_time) as time,\n" +
            "  max(wmr.consumption) as water_value\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{waterId}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  DATE (wmr.read_time)=DATE(now())\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<WaterDo> getWaterPerHour(@Param("waterId") Long waterId);

    /**
     * 根据水表的主键来获取昨天最后一个读数值
     * @param waterId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  wmr.consumption\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{waterId}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  DATE(wmr.read_time)<=#{time}\n" +
            "ORDER BY\n" +
            "  wmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getWaterLastOneYesterday(@Param("waterId") Long waterId);

    /**
     * 根据水表的主键来获取当月的每天的数值(每个时间段内最后的值作为这个时间段的结束)
     * @param waterId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  Day(wmr.read_time) as time,\n" +
            "  max(wmr.consumption) as water_value\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{waterId}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  YEAR (wmr.read_time)=YEAR(now())\n" +
            "AND\n" +
            "  MONTH (wmr.read_time)=MONTH(now())\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<WaterDo> getWaterPerDay(@Param("waterId") Long waterId);

    /**
     * 返回主键为{id}水表在本年本月第（day）日的百分比能耗
     * @param day  日期 整数就行 1号time=1 2号time=2
     * @param waterId 水表id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  HOUR(wmr.read_time) as time,\n" +
            "  max(wmr.consumption) as water_value\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{waterId}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  year(wmr.read_time) = year(now())\n" +
            "AND\n" +
            "  month(wmr.read_time) = month(now())\n" +
            "AND\n" +
            "  DAY(wmr.read_time) = #{day}\n" +
            "GROUP BY\n" +
            "  time;" +
            ""})
    List<WaterDo> getWaterByPercentage(@Param("day") int day, @Param("waterId") Long waterId);

    /**
     * 返回主键为{id}水表在time日期指定的前一天最后一条数据的值
     * @param time  日期 2017-01-01
     * @param waterId 水表id
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  wmr.consumption\n" +
            "FROM\n" +
            "  ", TABLE_WATER_INFO ," wi,\n" +
            "  ", TABLE_WATER_METER_RECORD ," wmr\n" +
            "WHERE\n" +
            "  wi.id = #{waterId}\n" +
            "AND\n" +
            "  wi.id=wmr.water_info_id\n" +
            "AND\n" +
            "  DATE (wmr.read_time) <= DATE (date_sub(#{time},INTERVAL 1 DAY))\n" +
            "ORDER BY\n" +
            "  wmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    Double getWaterLastOneYesterdayByDay(@Param("time") String time, @Param("waterId") Long waterId);

}

package com.dou.huzhou.dao.hz;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    String TABLE_WATER_METER_RECORD = "power_meter_record";
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
    @Select({" SELECT epp FROM ", TABLE_WATER_METER_RECORD ," " +
            "WHERE YEAR(read_time)=(SELECT YEAR(read_time) FROM ", TABLE_WATER_METER_RECORD ," ORDER BY YEAR(read_time)DESC ,MONTH(read_time) DESC LIMIT 0,1)\n" +
            "AND MONTH(read_time)=(SELECT MONTH(read_time)-1 FROM ", TABLE_WATER_METER_RECORD ," ORDER BY YEAR(read_time)DESC ,MONTH(read_time) DESC LIMIT 0,1)\n" +
            "ORDER BY read_time DESC LIMIT 0,1 "})
    Double getLastMouthValue(@Param("id") Long id);
}

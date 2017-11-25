package com.dou.huzhou.dao.hz;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    @Select({" SELECT epp FROM ", TABLE_POWER_METER_RECORD ," " +
            "WHERE power_info_id = #{id} " +
            "AND YEAR(read_time)=(SELECT YEAR(read_time) FROM ", TABLE_POWER_METER_RECORD ," ORDER BY YEAR(read_time)DESC ,MONTH(read_time) DESC LIMIT 0,1)\n" +
            "AND MONTH(read_time)=(SELECT MONTH(read_time)-1 FROM ", TABLE_POWER_METER_RECORD ," ORDER BY YEAR(read_time)DESC ,MONTH(read_time) DESC LIMIT 0,1)\n" +
            "ORDER BY read_time DESC LIMIT 0,1 "})
    Double getLastMouthValue(@Param("id") Long id);


}

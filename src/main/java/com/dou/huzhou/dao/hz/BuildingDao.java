package com.dou.huzhou.dao.hz;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:34
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface BuildingDao {
    String TABLE_BUILDING_INFO = "building_info";

    @Select({" select building_no from ", TABLE_BUILDING_INFO ," where id = #{id} "})
    String getBuildingNo(@Param("id") Long id);
}

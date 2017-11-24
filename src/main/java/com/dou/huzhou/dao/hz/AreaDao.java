package com.dou.huzhou.dao.hz;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:35
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface AreaDao {
    String TABLE_AREA_INFO = "area_info";

    @Select({" select area_no from ", TABLE_AREA_INFO ," where id = #{id} "})
    String getAreaNo(@Param("id") Long id);
}

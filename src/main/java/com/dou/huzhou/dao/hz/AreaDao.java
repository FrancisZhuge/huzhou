package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.Area;
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
    String SELECT_FIELDS = " id, area_no, area_name, provice_id, city_id, area_id, address, jigou ";

    /**
     * 根据{id}查找{area_no}字段
     * @param id area表的主键
     * @return
     */
    @Select({" select area_no from ", TABLE_AREA_INFO ," where id = #{id} "})
    String getAreaNo(@Param("id") Long id);

    /**
     * 根据id查找Area对象
     * @param id
     * @return
     */
    @Select({" select ",SELECT_FIELDS," from ",TABLE_AREA_INFO," where id = #{id}"})
    Area getById(@Param("id") Long id);
}

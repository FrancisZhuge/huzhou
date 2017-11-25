package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.MapVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 22:27
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface MapDao {
    String TABLE_AREA_INFO = "area_info";
    String TABLE_BUILDING_INFO = "building_info";
    String TABLE_COMPANY_INFO = "company_info";
    String TABLE_BUILDING_COMPANY = "building_company";

    @Select({"select b.building_name, c.company_name, c.id as companyId from", TABLE_AREA_INFO ," a, ", TABLE_BUILDING_INFO ," b, ", TABLE_COMPANY_INFO ," c, ", TABLE_BUILDING_COMPANY ," bc where a.id=#{id} and b.area_id = a.id and c.area_id = a.id and bc.building_id = b.id and bc.company_id = c.id"})
    List<MapVo> getMapInfoByArea(@Param("id") Long id);
}

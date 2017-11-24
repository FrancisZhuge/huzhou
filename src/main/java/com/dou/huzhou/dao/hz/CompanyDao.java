package com.dou.huzhou.dao.hz;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:31
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface CompanyDao {
    String TABLE_COMPANY_INFO = "company_info";

    @Select({" select company_no from ", TABLE_COMPANY_INFO ," where id = #{id} "})
    String getCompanyNo(@Param("id") Long id);
}

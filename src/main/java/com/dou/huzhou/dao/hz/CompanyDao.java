package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.Company;
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
    String SELECT_FIELDS = "id, company_no, company_name, address, area_id";
    /**
     * 根据主键查找公司的company_no
     * @param id
     * @return
     */
    @Select({" select company_no from ", TABLE_COMPANY_INFO ," where id = #{id} "})
    String getCompanyNo(@Param("id") Long id);

    /**
     * 根据主键查找company对象
     * @param id
     * @return
     */
    @Select({" select ",SELECT_FIELDS," from ",TABLE_COMPANY_INFO," where id = #{id}"})
    Company getById(@Param("id") Long id);
}

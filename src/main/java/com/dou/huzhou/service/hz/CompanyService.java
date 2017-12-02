package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.Area;
import com.dou.huzhou.domain.hz.Company;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:30
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface CompanyService {

    /**
     * 根据主键查找公司的company_no
     * @param id
     * @return
     */
    String getCompanyNo(Long id);

    /**
     * 根据主键查找公司
     * @param id
     * @return
     */
    Company getById(Long id);

    /**
     * 根据园区id获取园区下面所有的公司主键
     * @param areaId
     * @return
     */
    Long[] getCompanyIds(Long areaId);

    /**
     * 根据公司的主键获取公司的名称
     * @param id
     * @return
     */
    String getCompanyNameById(Long id);
}

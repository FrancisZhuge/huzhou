package com.dou.huzhou.service.hz;

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
}

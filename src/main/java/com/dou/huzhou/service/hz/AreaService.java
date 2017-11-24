package com.dou.huzhou.service.hz;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:29
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface AreaService {
    /**
     * 根据主键查找园区的area_no
     * @param id
     * @return
     */
    String getAreaNo(Long id);
}

package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.Area;
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

    /**
     * 根据id查找Area对象
     * @param id
     * @return
     */
    Area getById(Long id);
}

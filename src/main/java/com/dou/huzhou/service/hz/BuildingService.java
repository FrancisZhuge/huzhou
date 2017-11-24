package com.dou.huzhou.service.hz;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 16:30
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface BuildingService {
    /**
     * 根据主键查找大楼的building_no
     * @param id
     * @return
     */
    String getBuildingNo(Long id);
}

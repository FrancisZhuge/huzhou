package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.PowerWaterAndCompanyVo;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 12:34
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface StatisticsService {
    /**
     * 获取所有公司所有电表最新的能耗折合成标准煤的数量
     * @return
     */
    Double getCoal();

    /**
     * 获得有序的电力和水力集合
     *  companyName
     *  powerValue
     *  waterValue
     * @return
     */
    List<PowerWaterAndCompanyVo> getPowerAndWaterByOrder();
}

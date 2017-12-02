package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.EnergyConsumptionDo;
import com.dou.huzhou.domain.hz.EnergyConsumptionVo;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/30, 9:34
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface ManagerService {
    /**
     * 获取当天最新的一条消息
     * @param powerId
     * @return
     */
    EnergyConsumptionDo getToadyEnergyConsumptionById(Long powerId);

    /**
     * 获取所有公司的列表
     * @return
     */
    List<EnergyConsumptionVo> getEnergyList();
}

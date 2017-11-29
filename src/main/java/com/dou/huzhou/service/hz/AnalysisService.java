package com.dou.huzhou.service.hz;

import com.dou.huzhou.domain.hz.PowerVo;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/29, 9:27
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public interface AnalysisService {
    /**
     * 获取主键为{companyId}的公司当前星期的用电情况
     * @param companyId 公司主键
     * @return
     */
    List<PowerVo> getCurrentWeek(Long companyId);
}

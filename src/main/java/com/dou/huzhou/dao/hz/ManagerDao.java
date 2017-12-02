package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.hz.EnergyConsumptionDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/12/1, 14:43
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface ManagerDao {
    String VOLTAGE = "uan";//电压
    String ELECTRICITY = "ia";//电流
    String ACTIVE_POWER = "ps";//有功功率
    String TOTAL_POWER = "ps";//总功率
    String POWER_FACTOR = "pfs";//功率因数
    String TOTAL_POWER_FACTOR = "pfs";//总功率因数
    String TOTAL_ACTIVE_ENERGY = "by_kwhz";//有功总电能
    String POWERFUL_TIP_ENERGY = "by_kwhj";//有功尖电能
    String POWERFUL_PEAK_ENERGY = "by_kwhf";//有功峰电能
    String POWERFUL_VALLEY_ENERGY = "by_kwhg";//有功谷电能
    String RATE = "rate";//倍率
    String TIME = "read_time";//获取时间

    String TABLE_POWER_INFO = "power_info";
    String TABLE_POWER_METER_RECORD = "power_meter_record";

    /**
     * 获取当天最新的一条消息
     * @param powerId
     * @return
     */
    @Select({"" +
            "SELECT\n" +
            "  pmr.", VOLTAGE ," AS voltage,\n" +
            "  pmr.", ELECTRICITY ," AS electricity,\n" +
            "  pmr.", ACTIVE_POWER ," AS activePower,\n" +
            "  pmr.", TOTAL_POWER ," AS totalPower,\n" +
            "  pmr.", POWER_FACTOR ," AS powerFactor,\n" +
            "  pmr.", TOTAL_POWER_FACTOR ," AS totalPowerFactor,\n" +
            "  pmr.", TOTAL_ACTIVE_ENERGY ," AS totalActiveEnergy,\n" +
            "  pmr.", POWERFUL_TIP_ENERGY ," AS powerfulTipEnergy,\n" +
            "  pmr.", POWERFUL_PEAK_ENERGY ," AS powerfulPeakEnergy,\n" +
            "  pmr.", POWERFUL_VALLEY_ENERGY ," AS powerfulValleyEnergy,\n" +
            "  pi.", RATE ," AS rate,\n" +
            "  pmr.", TIME ," AS time\n" +
            "FROM\n" +
            "  ", TABLE_POWER_INFO ," pi,\n" +
            "  ", TABLE_POWER_METER_RECORD ," pmr\n" +
            "WHERE\n" +
            "  pi.id = #{powerId}\n" +
            "AND\n" +
            "  DATE (pmr.read_time) = DATE (now())\n" +
            "ORDER BY\n" +
            "  pmr.read_time DESC\n" +
            "LIMIT\n" +
            "  0,1;" +
            ""})
    EnergyConsumptionDo getToadyEnergyConsumptionById(@Param("powerId") Long powerId);
}

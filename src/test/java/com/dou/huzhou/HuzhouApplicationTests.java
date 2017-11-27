package com.dou.huzhou;

import com.dou.huzhou.dao.hz.MapDao;
import com.dou.huzhou.dao.hz.MonitorDao;
import com.dou.huzhou.dao.hz.WaterDao;
import com.dou.huzhou.domain.Role;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.*;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuzhouApplicationTests {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private MapDao mapDao;

	@Autowired
	private AreaService areaService;

	@Autowired
	private BuildingService buildingService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private MapService mapService;

	@Autowired
	private PowerService powerService;

	@Autowired
	private MonitorService monitorService;

	@Autowired
	private WaterService waterService;
	@Test
	public void contextLoads() {
		monitorService.getPowerAndWaterValueByPercentage(26, 35L);
	}
}

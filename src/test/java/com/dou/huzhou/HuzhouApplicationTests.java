package com.dou.huzhou;

import com.dou.huzhou.dao.hz.MapDao;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.MapVo;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.AreaService;
import com.dou.huzhou.service.hz.BuildingService;
import com.dou.huzhou.service.hz.CompanyService;
import com.dou.huzhou.service.hz.RoleService;
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
	@Test
	public void contextLoads() {
		List<MapVo> mapVos = mapDao.getMapInfoByArea(1L);
		System.out.println(mapVos);
	}
}

package com.dou.huzhou;

import com.dou.huzhou.domain.UserInfo;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuzhouApplicationTests {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;
	@Test
	public void contextLoads() {
		UserInfo userInfo = userService.getById(4L);
		System.out.println(userInfo);
		String role = roleService.spellAdminRole(userInfo);
		System.out.println(role);
	}
}

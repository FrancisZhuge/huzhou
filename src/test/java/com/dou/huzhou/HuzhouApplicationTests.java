package com.dou.huzhou;

import com.dou.huzhou.dao.UserDao;
import com.dou.huzhou.domain.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HuzhouApplicationTests {
	@Autowired
	private UserDao userDao;
	@Test
	public void contextLoads() {
		UserInfo admin = userDao.getByUsername("admin");
		System.out.println(admin);
	}

}

package com.dou.huzhou.script;

import com.dou.huzhou.domain.Role;
import com.dou.huzhou.domain.UserInfo;
import com.dou.huzhou.domain.hz.Area;
import com.dou.huzhou.domain.hz.Company;
import com.dou.huzhou.service.UserService;
import com.dou.huzhou.service.hz.AreaService;
import com.dou.huzhou.service.hz.CompanyService;
import com.dou.huzhou.service.hz.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Francis Zhuge
 * @Description: 权限生成规则
 * @Date: Created in 2017/11/25, 11:02
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleScript {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private CompanyService companyService;

    @Test
    public void createRole(){
        List<UserInfo> userInfos = userService.getAll();
        for(UserInfo userInfo:userInfos){
            if(userInfo.getAreaId() == null){
                Role role = roleService.getByRole("admin");
                if(role == null){
                    role = new Role();
                    role.setRole("admin");
                    role.setDescription("管理员");
                    role.setAvailable(true);
                    roleService.saveRole(role);
                }else {
                    continue;
                }
            }else if (userInfo.getCompanyId() == null){
                Area area = areaService.getById(userInfo.getAreaId());
                String rolename = area.getAreaNo()+".admin";
                Role role = roleService.getByRole(rolename);
                if(role == null){
                    role = new Role();
                    role.setRole(rolename);
                    role.setDescription(area.getAreaName()+"管理员");
                    role.setAvailable(true);
                    roleService.saveRole(role);
                }
            }else {
                Area area = areaService.getById(userInfo.getAreaId());
                Company company = companyService.getById(userInfo.getCompanyId());
                String rolename = area.getAreaNo()+"."+company.getCompanyNo()+".admin";
                String description = area.getAreaName()+company.getCompanyName()+"管理员";
                Role role = roleService.getByRole(rolename);
                if(role == null){
                    role = new Role();
                    role.setRole(rolename);
                    role.setDescription(description);
                    role.setAvailable(true);
                    roleService.saveRole(role);
                }
            }
        }
    }
}

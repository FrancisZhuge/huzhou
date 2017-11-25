package com.dou.huzhou.dao;

import com.dou.huzhou.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * @Author: Francis Zhuge
 * @Description: User的dao包
 * @Date: Created in 2017/11/20, 15:39
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface UserDao {
    //用户表
    String TABLE_USER = "user_info";
    //用户角色表
    String TABLE_USER_ROLE = "users_roles";
    //角色表
    String TABLE_ROLE = "roles";
    //插入字段
    String INSERT_FIELDS = "user_no, username, area_id, company_id, password, salt, locked";
    //查找字段
    String SELECT_FIELDS = "id, user_no, username, area_id, company_id, password, salt, locked";

    /**
     * 新增用户
     * @param userInfo
     */
    @Insert({" insert into ", TABLE_USER ," ( ", INSERT_FIELDS ," )values(#{userInfo.userNo},#{userInfo.username},#{userInfo.areaId},#{userInfo.companyId},#{userInfo.password},#{userInfo.salt},#{userInfo.locked}) "})
    @Options(useGeneratedKeys = true,keyProperty = "userInfo.id")
    void saveUser(@Param("userInfo")UserInfo userInfo);

    /**
     * 查找用户所有可用的角色
     * @param username
     * @return
     */
    @Select({" select role from ", TABLE_USER ," u, ", TABLE_ROLE ," r, ", TABLE_USER_ROLE ," ur where u.username=#{username} and u.id= ur.user_id and r.id=ur.role_id and r.available=1"})
    Set<String> findRolesAvailable(@Param("username") String username);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", TABLE_USER ," where username = #{username} "})
    UserInfo getByUsername(@Param("username") String username);

    /**
     * 根据主键查找用户
     * @param id
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", TABLE_USER ," where id = #{id} "})
    UserInfo getById(@Param("id") Long id);

    /**
     * 查找所有用户
     * @return
     */
    @Select({" select ", SELECT_FIELDS ," from ", TABLE_USER ," "})
    List<UserInfo> getAll();

}

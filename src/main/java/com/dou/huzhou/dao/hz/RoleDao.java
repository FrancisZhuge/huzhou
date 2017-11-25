package com.dou.huzhou.dao.hz;

import com.dou.huzhou.domain.Role;
import org.apache.ibatis.annotations.*;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/21, 11:10
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
@Mapper
public interface RoleDao {
    String TABLE_ROLE = "roles";
    String INSERT_FIELDS = "role, description, available";
    String SELECT_FIELDS = "id, role, description, available";

    /**
     * 新建一个权限
     * @param role
     */
    @Insert({"insert into ", TABLE_ROLE ,"(", INSERT_FIELDS ,") values (#{role.role},#{role.description},#{role.available}) "})
    @Options(useGeneratedKeys = true,keyProperty = "role.id")
    void saveRole(@Param("role") Role role);

    /**
     * 根据role查找一个角色
     * @param role
     * @return
     */
    @Select({"select ", SELECT_FIELDS ," from ", TABLE_ROLE ," where role = #{role}"})
    Role getByRole(@Param("role") String role);
}

package com.dou.huzhou.domain;

/**
 * @Author: Francis Zhuge
 * @Description: 角色类
 * @Date: Created in 2017/10/15, 15:42
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class Role {
    //主键
    private Long id;
    //角色标识 程序中判断使用,如"admin"
    private String role;
    //角色描述
    private String description;
    //是否可用,如果不可用将不会添加给用户
    private Boolean available = Boolean.FALSE;

    public Role() {
    }

    public Role(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id != null ? id.equals(role.id) : role.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}

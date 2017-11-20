package com.dou.huzhou.web.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/20, 10:05
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class AjaxBody {
    //提供前端调用的回调参数
    private String callback;
    //返回前端的编码
    private int code;
    //返回前端的数据
    private Object data;
    //返回前端的错误提示(如果有错误填写)
    private String error;
    //判断是否有有个角色,0表示没有角色，1表示有角色
    private String role;
    //判断是否有有个权限，0表示没有权限，1表示有权限
    private String permission;

    public AjaxBody() {
    }

    public AjaxBody(String callback, int code, Object data, String error, String role, String permission) {
        this.callback = callback;
        this.code = code;
        this.data = data;
        this.error = error;
        this.role = role;
        this.permission = permission;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("callback",callback);
            jsonObject.put("code",code);
            jsonObject.put("data",data);
            jsonObject.put("error",error);
            jsonObject.put("role",role);
            jsonObject.put("permission",permission);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }

}

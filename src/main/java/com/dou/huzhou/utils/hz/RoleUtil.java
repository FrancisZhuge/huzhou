package com.dou.huzhou.utils.hz;

import com.dou.huzhou.domain.UserInfo;
import org.apache.shiro.subject.Subject;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/24, 15:55
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class RoleUtil {
//    public static boolean hasAdminorAreaAdmin(Subject curUser, UserInfo user){
//        if(user.getAreaId()==null){
//            if(curUser.hasRole("admin")){
//                return true;
//            }
//            return false;
//        }
//        if(user.getBuildingId()==null){
//            if(curUser.hasRole())
//        }
//    }
    public static String spellAdminRole(UserInfo user){
//        if(user.getAreaId() == null){
//            return "admin";
//        }else if(user.getBuildingId() == null){
//            return user;
//        }
        return "";
    }
}

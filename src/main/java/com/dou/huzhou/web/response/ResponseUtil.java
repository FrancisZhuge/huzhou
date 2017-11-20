package com.dou.huzhou.web.response;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/11/20, 10:08
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class ResponseUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResponseUtil.class);

    /**
     * 服务器正常      200
     * @return
     */
    public static String responseOk(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        LOGGER.info("server ok.");
        return ajaxBody.toString();
    }

    /**
     * 服务器正常返回数据   200
     * @param data
     * @return
     */
    public static String responseOkWithData(JSONObject data){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        ajaxBody.setData(data);
        LOGGER.info("server ok,data={}.",data);
        return ajaxBody.toString();
    }
    /**
     * 参数错误     400
     * @return
     */
    public static String responseIllegalArgus(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_ILLEGAL_ARGUS);
        LOGGER.error("illegal arguments.");
        return ajaxBody.toString();
    }

    /**
     * 参数错误带返回值    400
     * @param error
     * @return
     */
    public static String responseIllegalArgus(String error){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_ILLEGAL_ARGUS);
        ajaxBody.setError(error);
        LOGGER.error("illegal arguments, error={}.",error);
        return ajaxBody.toString();
    }

    /**
     * 服务器错误    500
     * @return
     */
    public static String responmseServerError(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_SERVER_ERROR);
        LOGGER.error("server error.");
        return ajaxBody.toString();
    }

    /**
     * 服务器错误    500
     * @param error 错误原因
     * @return
     */
    public static String responseServerError(String error){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_SERVER_ERROR);
        ajaxBody.setError(error);
        LOGGER.error("server error = {}.",error);
        return ajaxBody.toString();
    }

}

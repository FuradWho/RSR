package com.rsr.furad.util;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 13375
 */
public class JsonMsg {
    /**
     * 是否正确
     */
    private Boolean success;
    /**
     * 错误代码
     */
    private Long errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    private Long id; //判断成功还是失败，1代表成功，0代表失败
    private String message; //返回信息
    private String location; //返回路径（如果成功了跳转到什么路径上）
    private Map<String,Object> map = new HashMap<>(); //如果需要分页携带什么数据下去

    public JsonMsg() {
    }

    public JsonMsg(Long id, String message, String location, Map<String, Object> map) {
        this.id = id;
        this.message = message;
        this.location = location;
        this.map = map;
    }

    public JsonMsg(Boolean success, Long errorCode, String errorMsg, Long id, String message, String location, Map<String, Object> map) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.id = id;
        this.message = message;
        this.location = location;
        this.map = map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Long getErrorCode() {
        return errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}


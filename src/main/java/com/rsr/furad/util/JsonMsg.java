package com.rsr.furad.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * @author 13375
 */
@Data
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
    /**
     * 判断成功还是失败，1代表成功，0代表失败
     */
    private Long id;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回路径（如果成功了跳转到什么路径上）
     */
    private String location;
    /**
     * 如果需要分页携带什么数据下去
     */
    private Map<String, Object> map = new HashMap<>();

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

}


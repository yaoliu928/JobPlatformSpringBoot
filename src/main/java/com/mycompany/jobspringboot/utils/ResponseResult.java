package com.mycompany.jobspringboot.utils;

import com.mycompany.jobspringboot.utils.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class ResponseResult {
    // status code
    private Integer code;
    // response message
    private String msg;
    // response data
    private Object data;

    /**
     * response success with code, message and data
     * @param data
     */
    public ResponseResult(Object data) {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    /**
     * response success with code, message
     * @param
     */
    public ResponseResult() {
        this.code = ResultCodeEnum.SUCCESS.getCode();
        this.msg = ResultCodeEnum.SUCCESS.getMsg();
        this.data = null;
    }

    /**
     * response with specific code, message and data
     * @param resultCodeEnum
     * @param data
     */
    public ResponseResult(ResultCodeEnum resultCodeEnum, Object data) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = data;
    }

    /**
     * response with specific code, message
     * @param resultCodeEnum
     * @param
     */
    public ResponseResult(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMsg();
        this.data = null;
    }

    /**
     * set status code, message and data manually
     * @param code
     * @param msg
     * @param data
     */
    public ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * set status code and message
     * @param code
     * @param msg
     * @param
     */
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
}

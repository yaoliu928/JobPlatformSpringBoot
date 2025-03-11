package com.mycompany.jobspringboot.utils.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    PARAM_ERROR(400, "parameter error"),
    NOT__FOUND(404, "not found"),
    SERVER_ERROR(500, "server error"),
    DB_ERROR(505, "database error"),
    UNIQUE_KEY_ERROR(506, "unique key error"),
    UNKNOWN_ERROR(600, "unknown error");

    // status code
    private Integer code;
    // response message
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

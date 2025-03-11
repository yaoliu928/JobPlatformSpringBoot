package com.mycompany.jobspringboot.utils.exception;

import com.mycompany.jobspringboot.utils.ResponseResult;
import com.mycompany.jobspringboot.utils.enums.ResultCodeEnum;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.BindException;

// Global exception handler
@RestControllerAdvice
public class GlobalExceptionHandle {

    /***
     * param validation exception handler
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseResult bindExceptionHandler(BindException e) {
        // get binding result from exception
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder strBuilder = new StringBuilder("validation failed: ");
        // traverse all bindingResult related field errors
        for(FieldError fieldError : bindingResult.getFieldErrors()) {
            strBuilder
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append(",");
        }

        String message = strBuilder.toString();
        return new ResponseResult(ResultCodeEnum.PARAM_ERROR.getCode(), message);
    }

    /**
     * duplicate key exception handler
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseResult duplicateKeyExceptionHandler(DuplicateKeyException e) {
        return new ResponseResult(ResultCodeEnum.UNIQUE_KEY_ERROR.getCode(),e.getCause().getMessage());
    }

    /**
     * unknown exception handler
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult unknownExceptionHandler(Exception e) {
        return new ResponseResult(ResultCodeEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
    }
}

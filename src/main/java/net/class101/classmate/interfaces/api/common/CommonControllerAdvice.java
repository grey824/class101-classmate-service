package net.class101.classmate.interfaces.api.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public static CommonResponse onException(Exception e) {
        log.error("onException. errorMessage = {}", e.getMessage());
        return CommonResponse.fail(e.getMessage(), ErrorCode.SERVER_ERROR);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public static CommonResponse onInvalidParamException(IllegalArgumentException e) {
        log.error("onInvalidParamException. errorMessage = {}", e.getMessage());
        return CommonResponse.fail(e.getMessage(), ErrorCode.INVALID_PARAM);
    }
}

package net.class101.classmate.interfaces.api.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    private Result result;
    private T data;
    private String message;
    private ErrorCode errorCode;

    public static <T> CommonResponse success(T data, String message) {
        return CommonResponse.builder()
                .result(Result.SUCCESS)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse success(T data) {
        return success(data, null);
    }

    public static CommonResponse success(String message) {
        return success(null, message);
    }

    public static CommonResponse fail(String message, ErrorCode errorCode) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .message(message)
                .errorCode(errorCode)
                .build();
    }
}

enum Result {
    SUCCESS, FAIL
}
package net.class101.classmate.interfaces.api.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SERVER_ERROR("일시적인 서버 에러가 발생했습니다. 잠시 후 다시 접속해주세요."),
    INVALID_PARAM("잘못된 요청값입니다.");

    private String description;
}

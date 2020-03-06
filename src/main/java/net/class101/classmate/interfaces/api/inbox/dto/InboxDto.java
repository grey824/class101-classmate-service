package net.class101.classmate.interfaces.api.inbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InboxDto {

    @Data
    public static class CreateRequest {
        @NotNull(message="userId 필드를 입력하세요.")
        private String userId;

        @NotNull(message="title 필드를 입력하세요.")
        private String title;

        @NotNull(message="body 필드를 입력하세요.")
        private String body;

        @NotNull(message="pictureUrl 필드를 입력하세요.")
        @Pattern(regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message="URL 형식으로 입력해주세요.")
        private String pictureUrl;

        @NotNull(message="type 필드를 입력하세요.")
        private String type;

        @NotNull(message="actionType 필드를 입력하세요.")
        private String actionType;

        @NotNull(message="hided 필드를 입력하세요.")
        private Boolean hided;

        @NotNull(message="newly 필드를 입력하세요.")
        private Boolean newly;

        private String createId;

        @NotNull(message="payload 필드를 입력하세요.")
        private InboxPayloadDto.CreateRequest payload;
    }

    @Getter
    @AllArgsConstructor
    public static class CreateResponse {
        private Long inboxId;
        private String createId;
    }

    @Data
    public static class DetailRequest {
        @NotNull(message="userId 필드를 입력하세요.")
        private String userId;

        @Min(value = 0, message = "pageIndex는 0 이상 값을 입력하세요.")
        @Max(value = 50, message = "pageIndex의 최대값은 50을 넘을 수 없습니다.")
        private Long pageIndex;

        @Min(value = 1, message = "pageSize는 1 이상 값을 입력하세요.")
        @Max(value = 50, message = "pageSize의 최대값은 50을 넘을 수 없습니다.")
        private Long pageSize;
    }

    @Data
    public static class DetailResponse {
        private String userId;
        private String title;
        private String body;
        private String pictureUrl;
        private String type;
        private Boolean hided;
        private Boolean newly;
        private String payloadTitle;
        private String payloadUrl;
    }

}

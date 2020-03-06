package net.class101.classmate.interfaces.api.inbox.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InboxPayloadDto {

    @Getter
    @Setter
    @ToString
    public static class CreateRequest {
        @NotNull(message="title 필드를 입력하세요.")
        private String title;

        @NotNull(message="url 필드를 입력하세요.")
        @Pattern(regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message="URL 형식으로 입력해주세요.")
        private String url;
    }

}

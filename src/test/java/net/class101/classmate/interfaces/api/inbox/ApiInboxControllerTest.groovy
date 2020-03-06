package net.class101.classmate.interfaces.api.inbox

import com.fasterxml.jackson.databind.ObjectMapper
import net.class101.classmate.application.InboxFacade
import net.class101.classmate.interfaces.api.common.CommonControllerAdvice
import net.class101.classmate.interfaces.api.inbox.dto.InboxPayloadDto
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Shared
import spock.lang.Specification

import java.nio.charset.StandardCharsets

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

@SpringBootTest
class ApiInboxControllerTest extends Specification {

    def apiInboxController
    def inboxFacade = Mock(InboxFacade)

    MockMvc mockMvc

    @Shared
    ObjectMapper objectMapper

    def setupSpec() {
        objectMapper = new ObjectMapper()
    }

    void setup() {
        apiInboxController = new ApiInboxController(inboxFacade)
        mockMvc = standaloneSetup(apiInboxController)
                .setControllerAdvice(new CommonControllerAdvice())
                .build()
    }

    def "/v1/inbox/create : Inbox를 생성한다"() {
        given: '요청 파라미터를 구성한다'
        def request = [
                userId: 'testUser',
                title: '제목',
                body: '테스트',
                pictureUrl: 'https://cdn.class101.net/images/370dd8fa-6c05-4e51-bf2f-96273d471395',
                type: 'EVENT',
                actionType: 'GO_TO_SCENE',
                hided: Boolean.FALSE,
                newly: Boolean.TRUE,
                payload: new InboxPayloadDto.CreateRequest(
                        title: '타임세일',
                        url: 'https://class101.net/new/collections/5e294b03522b5965f5355b78'
                )
        ]

        when: 'API 를 호출한다'
        def response = mockMvc.perform(post('/v1/inbox/create')
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)))
                .andReturn()
                .getResponse()

        then:
        response.getStatus() == HttpStatus.OK.value()
    }

    def "/v1/inbox/create : Inbox를 생성한다 - pictureUrl이 URL 형식에 맞지 않음"() {
        given: '요청 파라미터를 구성한다'
        def request = [
                userId: 'testUser',
                title: '제목',
                body: '테스트',
                pictureUrl: 'httasdps://cdn.class101.net/images/370dd8fa-6c05-4e51-bf2f-96273d471395',
                type: 'EVENT',
                actionType: 'GO_TO_SCENE',
                hided: Boolean.FALSE,
                newly: Boolean.TRUE,
                payload: new InboxPayloadDto.CreateRequest(
                        title: '타임세일',
                        url: 'https://class101.net/new/collections/5e294b03522b5965f5355b78'
                )
        ]

        when: 'API 를 호출한다'
        def response = mockMvc.perform(post('/v1/inbox/create')
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)))
                .andReturn()
                .getResponse()

        then:
        response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()
        response.getContentAsString(StandardCharsets.UTF_8).contains('URL 형식으로 입력해주세요')
    }

    def "/v1/inbox/details : Inbox를 조회한다"() {
        given: '요청 파라미터를 구성한다'
        def request = [
                userId: 'testUser'
        ]

        when: 'API 를 호출한다'
        def response = mockMvc.perform(post('/v1/inbox/details')
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)))
                .andReturn()
                .getResponse()

        then:
        response.getStatus() == HttpStatus.OK.value()
    }
}

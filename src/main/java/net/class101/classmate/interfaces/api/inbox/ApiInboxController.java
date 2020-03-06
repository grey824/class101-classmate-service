package net.class101.classmate.interfaces.api.inbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.classmate.application.InboxFacade;
import net.class101.classmate.interfaces.api.common.CommonResponse;
import net.class101.classmate.interfaces.api.inbox.dto.InboxDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/inbox")
public class ApiInboxController {

    private final InboxFacade inboxFacade;

    @PostMapping("/create")
    public CommonResponse create(@RequestBody @Valid InboxDto.CreateRequest request) {
        log.info("[ApiInboxController.create] request = {}", request);
        InboxDto.CreateResponse response = inboxFacade.create(request);
        log.info("[ApiInboxController.create] response = {}", response);

        return CommonResponse.success(response);
    }

    @PostMapping("/details")
    public CommonResponse getDetails(@RequestBody @Valid InboxDto.DetailRequest request) {
        log.info("[ApiInboxController.getDetails] request = {}", request);
        List<InboxDto.DetailResponse> responseList = inboxFacade.getDetailList(request);
        log.info("[ApiInboxController.getDetails] responseList = {}", responseList);

        return CommonResponse.success(responseList);
    }

}

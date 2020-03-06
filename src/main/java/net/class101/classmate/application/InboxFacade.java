package net.class101.classmate.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.classmate.domain.inbox.Inbox;
import net.class101.classmate.domain.inbox.InboxService;
import net.class101.classmate.interfaces.api.inbox.dto.InboxDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InboxFacade {

    private final InboxService inboxService;

    private final ModelMapper modelMapper;

    public InboxDto.CreateResponse create(InboxDto.CreateRequest request) {
        Inbox inbox = inboxService.createWithPayload(request);
        return convert(inbox);
    }

    private InboxDto.CreateResponse convert(Inbox savedInbox) {
        return new InboxDto.CreateResponse(savedInbox.getId(), savedInbox.getInboxPayload().getCreateId());
    }

    public List<InboxDto.DetailResponse> getDetailList(InboxDto.DetailRequest request) {
        List<Inbox> inboxList;
        if (request.getPageSize() != null & request.getPageSize() != null) {
            inboxList = inboxService.getListWithRange(request);
        } else {
            inboxList = inboxService.findByUserId(request.getUserId());
        }

        return inboxList.stream().map(this::convertToDetail).collect(Collectors.toList());
    }

    private InboxDto.DetailResponse convertToDetail(Inbox inbox) {
        InboxDto.DetailResponse response = modelMapper.map(inbox, InboxDto.DetailResponse.class);
        response.setPayloadTitle(inbox.getInboxPayload().getTitle());
        response.setPayloadUrl(inbox.getInboxPayload().getUrl());

        return response;
    }

}

package net.class101.classmate.domain.inbox;

import net.class101.classmate.interfaces.api.inbox.dto.InboxDto;

import java.util.List;

public interface InboxService {

    Inbox findBy(Long id);

    List<Inbox> findByUserId(String userId);

    Inbox createWithPayload(InboxDto.CreateRequest request);

    List<Inbox> getListWithRange(InboxDto.DetailRequest request);

}

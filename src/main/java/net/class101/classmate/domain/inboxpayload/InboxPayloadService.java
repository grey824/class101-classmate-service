package net.class101.classmate.domain.inboxpayload;

import net.class101.classmate.interfaces.api.inbox.dto.InboxPayloadDto;

import java.util.Optional;

public interface InboxPayloadService {

    InboxPayload findBy(Long id);

    Optional<InboxPayload> findByCreateId(String createId);

    Optional<InboxPayload> create(InboxPayloadDto.CreateRequest request);

}

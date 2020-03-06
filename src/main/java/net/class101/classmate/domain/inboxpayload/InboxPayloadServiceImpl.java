package net.class101.classmate.domain.inboxpayload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.classmate.interfaces.api.inbox.dto.InboxPayloadDto;
import net.class101.classmate.util.IdentifyUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InboxPayloadServiceImpl implements InboxPayloadService {

    private final InboxPayloadRepository inboxPayloadRepository;

    private static final String INBOX_PAYLOAD_ID_PREFIX = "IBP";

    @Override
    @Transactional(readOnly = true)
    public InboxPayload findBy(Long id) {
        return inboxPayloadRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Id 입니다. id = " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InboxPayload> findByCreateId(String createId) {
        return inboxPayloadRepository.findByCreateId(createId);
    }

    @Override
    @Transactional
    public Optional<InboxPayload> create(InboxPayloadDto.CreateRequest request) {
        InboxPayload inboxPayload = InboxPayload.builder()
                .createId(IdentifyUtil.generateUUID(INBOX_PAYLOAD_ID_PREFIX))
                .title(request.getTitle())
                .url(request.getUrl())
                .build();

        return Optional.of(inboxPayloadRepository.save(inboxPayload));
    }

}

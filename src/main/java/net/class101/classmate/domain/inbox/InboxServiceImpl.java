package net.class101.classmate.domain.inbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.class101.classmate.domain.inboxpayload.InboxPayload;
import net.class101.classmate.domain.inboxpayload.InboxPayloadService;
import net.class101.classmate.interfaces.api.inbox.dto.InboxDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InboxServiceImpl implements InboxService {

    private final InboxPayloadService inboxPayloadService;

    private final InboxRepository inboxRepository;

    @Override
    @Transactional(readOnly = true)
    public Inbox findBy(Long id) {
        return inboxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Id 입니다. id = " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inbox> findByUserId(String userId) {
        return inboxRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Inbox createWithPayload(InboxDto.CreateRequest request) {
        try {
            // ManyToOne
//            InboxPayload inboxPayload = inboxPayloadService.findByCreateId(request.getCreateId())
//                    .or(() -> inboxPayloadService.create(request.getPayload())).get();

            InboxPayload inboxPayload = inboxPayloadService.create(request.getPayload())
                    .orElseThrow(() -> new RuntimeException("Failed to create payload."));

            Inbox inbox = Inbox.builder()
                    .userId(request.getUserId())
                    .title(request.getTitle())
                    .body(request.getBody())
                    .pictureUrl(request.getPictureUrl())
                    .type(Inbox.Type.valueOf(request.getType()))
                    .actionType(Inbox.ActionType.valueOf(request.getActionType()))
                    .hided(request.getHided())
                    .newly(request.getNewly())
                    .inboxPayload(inboxPayload)
                    .build();

            return inboxRepository.save(inbox);
        } catch (Exception e) {
            log.error("Inbox create failed! {}", e);
            throw new RuntimeException("Inbox 생성 실패 - " + e.getMessage());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inbox> getListWithRange(InboxDto.DetailRequest request) {
        long offset = request.getPageIndex() * request.getPageSize();
        long limit = request.getPageSize();

        return inboxRepository.findByUserIdWithOffset(request.getUserId(), offset, limit);
    }

}

package net.class101.classmate.domain.inboxpayload;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InboxPayloadRepository extends JpaRepository<InboxPayload, Long> {

    Optional<InboxPayload> findByCreateId(String createId);

}

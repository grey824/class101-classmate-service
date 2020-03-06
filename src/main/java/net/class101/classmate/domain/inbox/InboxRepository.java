package net.class101.classmate.domain.inbox;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InboxRepository extends JpaRepository<Inbox, Long>, InboxRepositoryCustom {

}

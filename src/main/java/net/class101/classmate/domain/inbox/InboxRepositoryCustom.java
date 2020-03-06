package net.class101.classmate.domain.inbox;

import java.util.List;

public interface InboxRepositoryCustom {

    List<Inbox> findByUserId(String userId);

    List<Inbox> findByUserIdWithOffset(String userId, long offset, long limit);

}

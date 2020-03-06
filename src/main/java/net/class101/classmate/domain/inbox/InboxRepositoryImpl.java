package net.class101.classmate.domain.inbox;

import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static net.class101.classmate.domain.inbox.QInbox.inbox;
import static net.class101.classmate.domain.inboxpayload.QInboxPayload.inboxPayload;

@RequiredArgsConstructor
public class InboxRepositoryImpl implements InboxRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Inbox> findByUserId(String userId) {
        List<Predicate> predicates = Lists.newArrayList();
        predicates.add(inbox.userId.eq(userId));

        return queryFactory.selectFrom(inbox)
                .join(inbox.inboxPayload, inboxPayload).fetchJoin()
                .where(ExpressionUtils.allOf(predicates))
                .orderBy(inbox.id.desc())
                .fetch();
    }

    @Override
    public List<Inbox> findByUserIdWithOffset(String userId, long offset, long limit) {
        List<Predicate> predicates = Lists.newArrayList();
        predicates.add(inbox.userId.eq(userId));

        return queryFactory.selectFrom(inbox)
                .join(inbox.inboxPayload, inboxPayload).fetchJoin()
                .where(ExpressionUtils.allOf(predicates))
                .orderBy(inbox.id.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

}

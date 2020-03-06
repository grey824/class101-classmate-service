package net.class101.classmate.inbox.domain.inbox;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInbox is a Querydsl query type for Inbox
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInbox extends EntityPathBase<Inbox> {

    private static final long serialVersionUID = -1529906768L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInbox inbox = new QInbox("inbox");

    public final net.class101.classmate.inbox.domain.QAbstractEntity _super = new net.class101.classmate.inbox.domain.QAbstractEntity(this);

    public final EnumPath<Inbox.ActionType> actionType = createEnum("actionType", Inbox.ActionType.class);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final BooleanPath hided = createBoolean("hided");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final net.class101.classmate.inbox.domain.inboxpayload.QInboxPayload inboxPayload;

    public final BooleanPath newly = createBoolean("newly");

    public final StringPath pictureUrl = createString("pictureUrl");

    public final StringPath title = createString("title");

    public final EnumPath<Inbox.Type> type = createEnum("type", Inbox.Type.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath userId = createString("userId");

    public QInbox(String variable) {
        this(Inbox.class, forVariable(variable), INITS);
    }

    public QInbox(Path<? extends Inbox> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInbox(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInbox(PathMetadata metadata, PathInits inits) {
        this(Inbox.class, metadata, inits);
    }

    public QInbox(Class<? extends Inbox> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inboxPayload = inits.isInitialized("inboxPayload") ? new net.class101.classmate.inbox.domain.inboxpayload.QInboxPayload(forProperty("inboxPayload")) : null;
    }

}


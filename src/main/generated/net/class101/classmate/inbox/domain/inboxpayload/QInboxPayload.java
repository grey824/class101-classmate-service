package net.class101.classmate.inbox.domain.inboxpayload;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QInboxPayload is a Querydsl query type for InboxPayload
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QInboxPayload extends EntityPathBase<InboxPayload> {

    private static final long serialVersionUID = -2041978528L;

    public static final QInboxPayload inboxPayload = new QInboxPayload("inboxPayload");

    public final net.class101.classmate.inbox.domain.QAbstractEntity _super = new net.class101.classmate.inbox.domain.QAbstractEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath createId = createString("createId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath url = createString("url");

    public QInboxPayload(String variable) {
        super(InboxPayload.class, forVariable(variable));
    }

    public QInboxPayload(Path<? extends InboxPayload> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInboxPayload(PathMetadata metadata) {
        super(InboxPayload.class, metadata);
    }

}


package net.class101.classmate.domain.inbox;

import lombok.*;
import net.class101.classmate.domain.AbstractEntity;
import net.class101.classmate.domain.inboxpayload.InboxPayload;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "cm_inbox")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Inbox extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId", nullable = false)
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payloadId")
    private InboxPayload inboxPayload;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "pictureUrl", nullable = false)
    private String pictureUrl;

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "actionType", nullable = false)
    private ActionType actionType;

    @Column(name = "isHided", nullable = false)
    private Boolean hided;

    @Column(name = "isNewly", nullable = false)
    private Boolean newly;

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        EVENT("EVENT");

        private final String description;
    }

    @Getter
    @RequiredArgsConstructor
    public enum ActionType {
        GO_TO_SCENE("GO_TO_SCENE");

        private final String description;
    }

    @Builder
    public Inbox(String userId, String title, String body, String pictureUrl, Type type, ActionType actionType,
                 Boolean hided, Boolean newly, InboxPayload inboxPayload) {
        this.userId = userId;
        this.title = title;
        this.body = body;
        this.pictureUrl = pictureUrl;
        this.type = type;
        this.actionType = actionType;
        this.hided = hided;
        this.newly = newly;
        this.inboxPayload = inboxPayload;
    }

}

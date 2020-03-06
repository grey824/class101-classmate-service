package net.class101.classmate.domain.inboxpayload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.class101.classmate.domain.AbstractEntity;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "cm_inbox_payload")
@NoArgsConstructor
public class InboxPayload extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createId", nullable = false)
    private String createId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

    @Builder
    public InboxPayload(String createId, String title, String url) {
        this.createId = createId;
        this.title = title;
        this.url = url;
    }

}

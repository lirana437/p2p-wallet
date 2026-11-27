package com.liran.p2pwallet.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="idempotency_keys")
public class IdempotencyKey {
    @EmbeddedId
    private IdempotencyKeyId id;
    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @Column(name="response_payload", nullable = false,columnDefinition = "TEXT")
    private String responsePayload;
    @CreationTimestamp
    @Column(name="created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;


}

package com.liran.p2pwallet.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IdempotencyKeyId implements Serializable {
    @Column(name = "key_value", length = 100)
    private String keyValue;

    @Column(name = "user_id")
    private Long userId;
}

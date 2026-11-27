package com.liran.p2pwallet.entity;

import com.liran.p2pwallet.entity.enums.Currency;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name="wallets", uniqueConstraints = {
@UniqueConstraint(name = "uq_user_currency", columnNames = {"user_id", "currency"})
})
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id",nullable = false)
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name="currency" , nullable = false,length = 3)
    private Currency currency;
    @Column(name="balance", nullable = false, precision = 19, scale = 4)
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;
    @Version
    @Column(name="version",nullable = false)
    @Builder.Default
    private Long version = 0L;
    @CreationTimestamp
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;


}

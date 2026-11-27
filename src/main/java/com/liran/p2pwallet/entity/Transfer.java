package com.liran.p2pwallet.entity;


import com.liran.p2pwallet.entity.enums.Currency;
import com.liran.p2pwallet.entity.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transfers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source_wallet_id")
    private Wallet sourceWallet;
    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name="target_wallet_id", nullable = false)
    private Wallet targetWallet;
    @Column(name="amount", nullable = false, precision = 19 , scale = 4)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name="currency", nullable = false, length = 3)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false, length = 20)
    private TransferStatus status;
    @CreationTimestamp
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

}

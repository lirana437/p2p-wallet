package com.liran.p2pwallet.entity;

import com.liran.p2pwallet.entity.enums.EntryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="ledger_entries")
@Entity
public class LedgerEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="wallet_id", nullable = false)
    private Wallet wallet;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="transfer_id",nullable = false)
    private Transfer transfer;
    @Column(name="amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name="entry_type", nullable = false, length = 10)
    private EntryType entryType;
    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}

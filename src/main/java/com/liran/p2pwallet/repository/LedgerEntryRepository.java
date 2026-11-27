package com.liran.p2pwallet.repository;


import com.liran.p2pwallet.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedgerEntryRepository extends JpaRepository<LedgerEntry,Long> {
}

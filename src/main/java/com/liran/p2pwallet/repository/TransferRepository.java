package com.liran.p2pwallet.repository;

import com.liran.p2pwallet.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,Long> {
}

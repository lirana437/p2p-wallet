package com.liran.p2pwallet.repository;


import com.liran.p2pwallet.entity.IdempotencyKey;
import com.liran.p2pwallet.entity.IdempotencyKeyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotencyKeyRepository extends JpaRepository<IdempotencyKey, IdempotencyKeyId> {
}

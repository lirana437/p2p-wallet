package com.liran.p2pwallet.repository;

import com.liran.p2pwallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

package com.howto.DemoUser.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howto.DemoUser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
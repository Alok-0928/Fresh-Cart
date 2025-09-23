package com.freshcart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshcart.entities.User;
@Repository

public interface UserRepository  extends JpaRepository<User, Long>{
Optional<User> findByEmail(String email);
}

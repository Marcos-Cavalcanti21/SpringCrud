package com.spring.crud.domain.repository;

import com.spring.crud.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }

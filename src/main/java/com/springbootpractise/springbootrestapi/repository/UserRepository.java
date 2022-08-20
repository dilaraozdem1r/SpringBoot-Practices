package com.springbootpractise.springbootrestapi.repository;

import com.springbootpractise.springbootrestapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

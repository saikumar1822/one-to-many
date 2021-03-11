package com.hcl.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.onetomany.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

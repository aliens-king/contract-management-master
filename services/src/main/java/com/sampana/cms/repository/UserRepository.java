package com.sampana.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampana.cms.model.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    
}
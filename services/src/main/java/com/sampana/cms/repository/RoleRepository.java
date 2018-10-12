package com.sampana.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampana.cms.model.Role;



@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
package com.laptrinhjavawebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavawebshop.entity.RoleEntity;


public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
  RoleEntity findOneByCode (String Code);
}

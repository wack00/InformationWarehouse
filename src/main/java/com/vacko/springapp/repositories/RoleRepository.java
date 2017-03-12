package com.vacko.springapp.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacko.springapp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}

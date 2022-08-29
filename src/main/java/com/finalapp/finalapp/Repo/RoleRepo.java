package com.finalapp.finalapp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalapp.finalapp.Entity.ERole;
import com.finalapp.finalapp.Entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role , Long >  {
   Optional<Role> findByrolename(ERole rolename ); 


   
}

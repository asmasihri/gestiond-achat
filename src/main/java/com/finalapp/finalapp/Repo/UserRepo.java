package com.finalapp.finalapp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalapp.finalapp.Entity.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser , Long > {
    AppUser findByUsername(String username ) ;
      Boolean existsByUsername(String username ); 
      Boolean existsByEmail(String email ); 
      
   
}

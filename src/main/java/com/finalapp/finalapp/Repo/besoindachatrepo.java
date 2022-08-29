package com.finalapp.finalapp.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalapp.finalapp.Entity.Besoindachat;

@Repository
public interface besoindachatrepo  extends JpaRepository<    Besoindachat , Long>{
   Optional<Besoindachat> findById(Long id ) ;
   
}

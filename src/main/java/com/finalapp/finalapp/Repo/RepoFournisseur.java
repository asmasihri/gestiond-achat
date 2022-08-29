package com.finalapp.finalapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalapp.finalapp.Entity.Fournisseur;

@Repository
public interface RepoFournisseur extends JpaRepository<Fournisseur , Long  > {
   Fournisseur findByname(String name ) ; 
   
}

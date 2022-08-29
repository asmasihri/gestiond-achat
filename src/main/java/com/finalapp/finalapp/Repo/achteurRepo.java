package com.finalapp.finalapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalapp.finalapp.Entity.AcheteurDemande;
@Repository
public interface achteurRepo extends JpaRepository<AcheteurDemande , Long>  {
   
}

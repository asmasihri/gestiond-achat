package com.finalapp.finalapp.Services.serviceachteur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalapp.finalapp.Entity.AcheteurDemande;
import com.finalapp.finalapp.Repo.achteurRepo;

@Service
public class achteurservice {
   @Autowired
   achteurRepo achteurRepo ; 
   public AcheteurDemande  addcommande( AcheteurDemande acheteurDemande) {

      return achteurRepo.save(acheteurDemande) ; 
      
   }
   public List< AcheteurDemande >getachat(){
      return achteurRepo.findAll();

   }
   public void deletecommande(Long id ){
      AcheteurDemande acheteurDemande= achteurRepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
     achteurRepo.delete(acheteurDemande);

   }
   
   public AcheteurDemande updatestatus(Boolean fournisseur , Long id) {
   AcheteurDemande existingProduct = achteurRepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
    existingProduct.setStatus(fournisseur);
  
      return achteurRepo.save(existingProduct);
   }
   public AcheteurDemande updatereception(Boolean fournisseur , Long id) {
      AcheteurDemande existingProduct = achteurRepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
       existingProduct.setReception(fournisseur);
     
         return achteurRepo.save(existingProduct);
      }

}

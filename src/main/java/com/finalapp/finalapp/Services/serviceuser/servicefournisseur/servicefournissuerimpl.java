package com.finalapp.finalapp.Services.serviceuser.servicefournisseur;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.finalapp.finalapp.Entity.Fournisseur;
import com.finalapp.finalapp.Repo.RepoFournisseur;
@Service
public class servicefournissuerimpl implements servicefournisseur {
@Autowired
private RepoFournisseur repoFournisseur ; 

  
   @Override
   public void deleteFournisseur(Long id ) {
   Fournisseur fournisseur = repoFournisseur.findById(id ).orElseThrow(()-> new ResourceAccessException("Nor Exist"));       
   repoFournisseur.delete(fournisseur);
   }


   @Override
   public List<Fournisseur> getAllfournisseur() {
      return repoFournisseur.findAll();
   }
  
   @Override
   public Fournisseur addFournisseur(Fournisseur fournisseur) {
      return repoFournisseur.save(fournisseur);
   }

 

   @Override
   public Fournisseur updatFournisseur(Fournisseur fournisseur , Long id) {
    Fournisseur existingProduct = repoFournisseur.findById(id).orElseThrow(()-> new ResourceAccessException("not exist")) ; 
    existingProduct.setEmail(fournisseur.getEmail());
    existingProduct.setAdresse(fournisseur.getAdresse());
    existingProduct.setCode(fournisseur.getCode());
    existingProduct.setIBAN(fournisseur.getIBAN());
    existingProduct.setName(fournisseur.getName());
    existingProduct.setPays(fournisseur.getPays());
    existingProduct.setNumidentite(fournisseur.getNumidentite());
    existingProduct.setNumpatenet(fournisseur.getNumpatenet());
      return repoFournisseur.save(existingProduct);
   }


   @Override
   public Fournisseur getfournisseurbyid(Long id) {
      Fournisseur fournisseur = repoFournisseur.findById(id).orElseThrow(()-> new ResourceAccessException("msg"));

      return fournisseur;
   }


  
}

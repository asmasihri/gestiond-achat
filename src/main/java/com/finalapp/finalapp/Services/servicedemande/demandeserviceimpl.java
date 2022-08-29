package com.finalapp.finalapp.Services.servicedemande;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalapp.finalapp.Entity.Besoindachat;
import com.finalapp.finalapp.Repo.besoindachatrepo;
@Service
public class demandeserviceimpl implements demandeservice {
@Autowired
private besoindachatrepo besoindachatrepo ; 

   @Override
   public Besoindachat addachat(Besoindachat besoindachat) {
      
      return besoindachatrepo.save(besoindachat);
   }

   @Override
   public void deletedemande(Long id) {
      Besoindachat besoin = besoindachatrepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
       besoindachatrepo.delete(besoin) ; 
      
   }
   

   @Override
   public Besoindachat updatedemande(Long id, Besoindachat besoindachat) {
      Besoindachat besoin2 = besoindachatrepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
      besoin2.setArticle(besoindachat.getArticle());
      besoin2.setBudgetise(besoindachat.getBudgetise());
      besoin2.setCommentaire(besoindachat.getCommentaire());
      besoin2.setFournisseur(besoindachat.getFournisseur());
      besoin2.setQuantite(besoindachat.getMantant());
      besoin2.setTypeapp(besoindachat.getTypeapp());
      return besoindachatrepo.save(besoin2);
      
   }

   @Override
   public List<Besoindachat> getdemandes() {

      return besoindachatrepo.findAll();
   }

   @Override
   public Besoindachat getbyid(Long id) {
      Besoindachat besoin = besoindachatrepo.findById(id).orElseThrow(()-> new IllegalStateException("No")) ;
      return besoin ;
   }
   
}

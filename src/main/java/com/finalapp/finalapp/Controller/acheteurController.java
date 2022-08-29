package com.finalapp.finalapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalapp.finalapp.Entity.AcheteurDemande;
import com.finalapp.finalapp.Services.serviceachteur.achteurservice;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/achteur")


public class acheteurController {
   @Autowired
   achteurservice achteurservice ; 

   @PostMapping("/add")
   public AcheteurDemande addachteurdemande(@RequestBody AcheteurDemande acheteurDemande){
      return achteurservice.addcommande(acheteurDemande) ; 
   }
   @GetMapping("/get")
   public List<AcheteurDemande>  getachteur(){
      return achteurservice.getachat(); 
   }
   @DeleteMapping("/delete/{id}")
   public void deleteachteur(@PathVariable Long id ) {
      achteurservice.deletecommande(id);
      
   }
   @PutMapping("/update/{id}")
  // @PreAuthorize("hasRole('ROLE_BDD')")


  public AcheteurDemande updateFournisseur(@RequestBody Boolean status , @PathVariable Long id  ){
   return achteurservice.updatestatus(status , id); 
  }
  @PutMapping("/updates/{id}")
  // @PreAuthorize("hasRole('ROLE_BDD')")


  public AcheteurDemande updatereception(@RequestBody Boolean status , @PathVariable Long id  ){
   return achteurservice.updatereception(status , id); 
  }

   
}

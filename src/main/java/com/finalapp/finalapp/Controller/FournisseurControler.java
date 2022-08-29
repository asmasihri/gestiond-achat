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

import com.finalapp.finalapp.Entity.Fournisseur;
import com.finalapp.finalapp.Services.serviceuser.servicefournisseur.servicefournissuerimpl;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/fournisseur")

public class FournisseurControler {
 @Autowired 
 private servicefournissuerimpl servicefournissuerimpl ; 


    
   @GetMapping("/All")
  //  @PreAuthorize("hasRole('ROLE_BDD')")

   public List<Fournisseur> getall(){
      return servicefournissuerimpl.getAllfournisseur(); 
      
   }
  @PostMapping("/add")
  // @PreAuthorize("hasRole('ROLE_BDD')")

  public Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur){
   return servicefournissuerimpl.addFournisseur(fournisseur); 
  }
  @DeleteMapping("/delete/{id}")
  // @PreAuthorize("hasRole('ROLE_BDD')")

  public void deletefournisseur( @PathVariable  Long id ){
    servicefournissuerimpl.deleteFournisseur(id);
  }
  @PutMapping("/update/{id}")
  // @PreAuthorize("hasRole('ROLE_BDD')")


  public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur , @PathVariable Long id  ){
   return servicefournissuerimpl.updatFournisseur(fournisseur , id); 
  }
  
  @GetMapping("/get/{id}")
  public Fournisseur getbyid(@PathVariable Long id ){
    return servicefournissuerimpl.getfournisseurbyid(id); 
  }
  
}

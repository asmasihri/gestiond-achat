package com.finalapp.finalapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalapp.finalapp.Entity.Besoindachat;
import com.finalapp.finalapp.Services.servicedemande.demandeserviceimpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/demande")

public class demandeControl {
   @Autowired
   demandeserviceimpl demandeserviceimpl  ; 
@GetMapping("/get")
public List<Besoindachat> getdemandes() {
   return demandeserviceimpl.getdemandes() ; 
   
}


   @PostMapping("/add")

   public Besoindachat addbesoin(@RequestBody Besoindachat besoindachat ){
         return demandeserviceimpl.addachat(besoindachat) ; 
 
   }
   
   @DeleteMapping("/delete/{id}")
   public void deletedemande( @PathVariable Long id ) {
      demandeserviceimpl.deletedemande(id);

   }
   @PostMapping("update/{id}")
   public Besoindachat updatedmande(@PathVariable Long id , @RequestBody Besoindachat besoindachat){
      return demandeserviceimpl.updatedemande(id, besoindachat) ; 
   }
   
   @GetMapping("/get/{id}")
   public Besoindachat getbyid(@PathVariable Long id ){
     return demandeserviceimpl.getbyid(id); 
   }
}

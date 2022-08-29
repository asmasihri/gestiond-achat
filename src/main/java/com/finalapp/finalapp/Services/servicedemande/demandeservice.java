package com.finalapp.finalapp.Services.servicedemande;

import java.util.List;

import com.finalapp.finalapp.Entity.Besoindachat;

public interface demandeservice {
   Besoindachat addachat(Besoindachat besoindachat);
   void deletedemande(Long id ) ; 
   Besoindachat updatedemande(Long id , Besoindachat besoindachat);
   List<Besoindachat> getdemandes(); 
   Besoindachat getbyid(Long id) ; 

   
}

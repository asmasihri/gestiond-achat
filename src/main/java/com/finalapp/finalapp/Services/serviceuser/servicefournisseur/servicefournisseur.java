package com.finalapp.finalapp.Services.serviceuser.servicefournisseur;

import java.util.List;

import com.finalapp.finalapp.Entity.Fournisseur;

public interface servicefournisseur {
Fournisseur addFournisseur(Fournisseur fournisseur ) ; 
void deleteFournisseur(Long id ) ; 
Fournisseur updatFournisseur(Fournisseur fournisseur , Long id) ; 
List<Fournisseur> getAllfournisseur() ; 
Fournisseur getfournisseurbyid(Long id)  ; 

   
}

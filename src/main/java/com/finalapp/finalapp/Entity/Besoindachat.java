package com.finalapp.finalapp.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Besoindachat {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Long id ; 
   private String article ; 
   @NotBlank
   private String commentaire ; 
   private String fournisseur ; 
   private int quantite ;
   private int mantant ;
   private String typeapp ; 
   private Boolean budgetise ; 



   
}

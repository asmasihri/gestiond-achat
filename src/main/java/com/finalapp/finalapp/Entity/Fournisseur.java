package com.finalapp.finalapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fournisseur {
  

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ; 
   private int Code ; 
   private String adresse , pays ;
   private String name ; 
   @Email
   private String email ;
   private int numpatenet ; 
   private int numidentite ; 
   private String typeactivite; 
   private int IBAN ; 
   private int codeswift ;
   public Long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public int getCode() {
      return Code;
   }
   public void setCode(int code) {
      Code = code;
   }
   public String getAdresse() {
      return adresse;
   }
   public void setAdresse(String adresse) {
      this.adresse = adresse;
   }
   public String getPays() {
      return pays;
   }
   public void setPays(String pays) {
      this.pays = pays;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public int getNumpatenet() {
      return numpatenet;
   }
   public void setNumpatenet(int numpatenet) {
      this.numpatenet = numpatenet;
   }
   public int getNumidentite() {
      return numidentite;
   }
   public void setNumidentite(int numidentite) {
      this.numidentite = numidentite;
   }
   public String getTypeactivite() {
      return typeactivite;
   }
   public void setTypeactivite(String typeactivite) {
      this.typeactivite = typeactivite;
   }
   public int getIBAN() {
      return IBAN;
   }
   public void setIBAN(int iBAN) {
      IBAN = iBAN;
   }
   public int getCodeswift() {
      return codeswift;
   }
   public void setCodeswift(int codeswift) {
      this.codeswift = codeswift;
   } 



   
}

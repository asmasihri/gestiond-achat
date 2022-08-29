package com.finalapp.finalapp.Services.serviceuser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.finalapp.finalapp.Entity.AppUser;
import com.finalapp.finalapp.Entity.ERole;
import com.finalapp.finalapp.Entity.Role;
import com.finalapp.finalapp.Repo.RoleRepo;
import com.finalapp.finalapp.Repo.UserRepo;

@Service
public class servicesuserImp implements servuceuser {

   @Autowired
   private UserRepo userRepo ;
   @Autowired 
   private RoleRepo roleRepo ; 


   @Override
   public List<AppUser> getallusers() {
     
      
      return userRepo.findAll();
   }

   

   @Override
   public Role addNewRole(Role role) {
      return roleRepo.save(role);
   }



   @Override
   public void deleteUser(Long id) {
      AppUser appUser = userRepo.findById(id).orElseThrow( ()-> new ResourceAccessException("error"));
      userRepo.delete(appUser);
   }







   @Override
   public AppUser getUserById(Long id) {
      AppUser appUser = userRepo.findById(id).orElseThrow( ()-> new ResourceAccessException("error"));

      return appUser;
   }



   @Override
   public List<String> getlist() {
     List<AppUser>  r1= userRepo.findAll() ;
     List<String> all = new ArrayList<>() ;
     for (AppUser appUser : r1) {
      all.add(appUser.getRoles().toString().replaceAll("\\,|\\[|\\]|\\s", "").substring(18));
      
      
     }

     
      return all;
   }



   @Override
   public String getRole(Long id) {
      AppUser appUser =
       userRepo.findById(id).orElseThrow( ()-> new ResourceAccessException("error"));
      Set<Role> role1 = appUser.getRoles();
     String name =role1.toString().replaceAll("\\,|\\[|\\]|\\s\\)\\=\\(", "").substring(19); 
      
      return name ;
   }


  

   

   
}

package com.finalapp.finalapp.Services.serviceuser;

import java.util.List;

import com.finalapp.finalapp.Entity.AppUser;
import com.finalapp.finalapp.Entity.Role;

public interface servuceuser {
 List<AppUser> getallusers() ; 
  Role addNewRole(Role role); 
  void deleteUser(Long id ) ; 
  AppUser getUserById( Long id  ) ; 
  List<String> getlist() ; 
   String getRole(Long id) ; 


 
   
}

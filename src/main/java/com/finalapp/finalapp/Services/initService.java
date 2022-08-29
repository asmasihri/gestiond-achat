package com.finalapp.finalapp.Services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.finalapp.finalapp.Entity.AppUser;
import com.finalapp.finalapp.Entity.ERole;
import com.finalapp.finalapp.Entity.Role;
import com.finalapp.finalapp.Repo.RoleRepo;
import com.finalapp.finalapp.Repo.UserRepo;
import com.finalapp.finalapp.Services.serviceuser.servicesuserImp;

@Service
public class initService {
   @Autowired
   servicesuserImp servicesuserImp ; 
   @Autowired
   RoleRepo roleRepo ;
   @Autowired 
   UserRepo userRepo ;
  @Autowired
  PasswordEncoder passwordEncoder; 

public void initialRole() {
   Set<Role> roles = new HashSet<>(); 
   Role adminRole = new Role() ; 
   adminRole.setRolename(ERole.ROLE_ACHETEUR);
   roleRepo.save(adminRole); 

   Role usRole = new Role() ; 
   usRole.setRolename(ERole.ROLE_BDD);
   roleRepo.save(usRole); 
   Role achteurRole = new Role() ; 
   achteurRole.setRolename(ERole.ROLE_DEMANDEUR);
   roleRepo.save(achteurRole); 
   Role valid = new Role() ; 
   valid.setRolename(ERole.ROLE_VALIDATEUR);
   roleRepo.save(valid); 
   
   Role rec = new Role() ; 
   rec.setRolename(ERole.ROLE_RECEPTIONEUR);
   roleRepo.save(rec);
   Role admin = new Role() ; 
   admin.setRolename(ERole.ROLE_ADMIN); 
   roleRepo.save(admin) ; 
   AppUser user = new AppUser(); 
   user.setUsername("admin");
   user.setPassword(getEncodedPassword("1234567"));
   user.setEmail("admin@mail.com");
   roles.add(admin); 
   user.setRoles(roles);

   userRepo.save(user); 


   
}
public String getEncodedPassword(String password) {
   return passwordEncoder.encode(password);
}
   
}

package com.finalapp.finalapp.Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalapp.finalapp.Entity.AppUser;
import com.finalapp.finalapp.Entity.Besoindachat;
import com.finalapp.finalapp.Entity.ERole;
import com.finalapp.finalapp.Entity.Role;
import com.finalapp.finalapp.Repo.RoleRepo;
import com.finalapp.finalapp.Repo.UserRepo;
import com.finalapp.finalapp.Repo.besoindachatrepo;
import com.finalapp.finalapp.Services.servicedemande.demandeserviceimpl;
import com.finalapp.finalapp.Services.serviceuser.servicesuserImp;
import com.finalapp.finalapp.payload.request.SignupRequest;
import com.finalapp.finalapp.payload.response.MessageResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")

public class AdminController {
   @Autowired
   private servicesuserImp servicesuserimp ;
   @Autowired
   private RoleRepo roleRepo ;
   @Autowired
   private UserRepo userRepo ; 
   @Autowired 
   PasswordEncoder encoder ;
   @Autowired 
   demandeserviceimpl besoindachatrepo ; 
 


   @GetMapping("/get")
	// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
   public List<AppUser> listusers(){
      return servicesuserimp.getallusers() ; 

   }
    @GetMapping("/gett")
   public List<String> list(){
      return servicesuserimp.getlist() ; 

   }
   @GetMapping("/gets/{id}")
   public String getRole(@PathVariable Long id ){
      return servicesuserimp.getRole(id); 
   }



   @DeleteMapping("/delete/{id}")
   public void deleteuser(@PathVariable Long id){
       servicesuserimp.deleteUser(id);
   }
  
    //signup 
 @PostMapping("/signup")
 public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
   

            AppUser user = new 
            AppUser(signupRequest.getUsername() , signupRequest.getEmail() , encoder.encode( signupRequest.getPassword()));
            
          String s =  signupRequest.getRole();



          Set<String> strRoles = Arrays.asList(s.split(",")).stream()
         
          .collect(Collectors.toSet());

            Set<Role> roles = new HashSet<>(); 
            
            if (userRepo.existsByUsername(signupRequest.getUsername())) {
               return ResponseEntity
                     .badRequest()
                     .body(new MessageResponse("Error: Username is already taken!"));
            }
      
            if (userRepo.existsByEmail(signupRequest.getEmail())) {
               return ResponseEntity
                     .badRequest()
                     .body(new MessageResponse("Error: Email is already in use!"));
            }
      
            // 


            if (strRoles==null) {
               Role demandeRole = roleRepo.findByrolename(ERole.ROLE_DEMANDEUR).orElseThrow(
                  () -> new RuntimeException("Error:Role is not found")
               );
               roles.add(demandeRole);
               
               
            }else  {
               strRoles.forEach(role -> {
                  switch (role) {
                  case "achteur":

                     Role adminRole = roleRepo.findByrolename(ERole.ROLE_ACHETEUR)
                           .orElseThrow(() -> new RuntimeException("Error: Role is not found."));                          
                     roles.add(adminRole);
                     
                     break;
                     case "demandeur":
					Role modRole = roleRepo.findByrolename(ERole.ROLE_DEMANDEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
               case "Récéptionneur":
					Role recRole = roleRepo.findByrolename(ERole.ROLE_RECEPTIONEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(recRole);

					break;



               case "validateur":
					Role valid = roleRepo.findByrolename(ERole.ROLE_VALIDATEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(valid);

					break;
               case "BDD":
					Role bddrole = roleRepo.findByrolename(ERole.ROLE_BDD)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(bddrole);

					break;


               
                  default:
                     Role userRole = roleRepo.findByrolename(ERole.ROLE_DEMANDEUR)
                           .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                     roles.add(userRole);
                  }
               });
               
                  
                     
                
               };
               user.setRoles(roles);
               
               userRepo.save(user);
               return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

          
            }


 

     

}
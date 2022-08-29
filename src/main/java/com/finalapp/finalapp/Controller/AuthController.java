package com.finalapp.finalapp.Controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalapp.finalapp.Repo.RoleRepo;
import com.finalapp.finalapp.Repo.UserRepo;
import com.finalapp.finalapp.Services.UserDedailsImp;
import com.finalapp.finalapp.Services.initService;
import com.finalapp.finalapp.Services.serviceuser.servicesuserImp;
import com.finalapp.finalapp.jwt.JwtUtils;
import com.finalapp.finalapp.payload.request.LoginRequest;

import com.finalapp.finalapp.payload.response.JwtResponse;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")

public class AuthController {
   @Autowired
   AuthenticationManager authenticationManager ; 
   @Autowired 
   UserRepo userRepo ; 
   @Autowired 
   RoleRepo roleRepo ; 
   @Autowired 
   PasswordEncoder encoder ; 
   @Autowired
   JwtUtils jwtUtils ; 
   @Autowired 
   servicesuserImp servicesuserImp ;
   @Autowired 
   initService initService ;
   @PostConstruct
   public void init(){
      initService.initialRole();
      
   }
   //signin
   @PostMapping("/signin")
   public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//login with data of  sign in interface
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
      //generation
		String jwt = jwtUtils.generateJwtToken(authentication);

		
		UserDedailsImp userDetails = (UserDedailsImp) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles
                                     
                                     ));
	}

  
         
         
         }


   


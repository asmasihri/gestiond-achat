package com.finalapp.finalapp.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finalapp.finalapp.Entity.AppUser;
import com.finalapp.finalapp.Repo.UserRepo;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
   @Autowired
   UserRepo userRepo ; 


   @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      AppUser appUser = userRepo.findByUsername(username);
      
      return UserDedailsImp.build(appUser);
   }
   
}

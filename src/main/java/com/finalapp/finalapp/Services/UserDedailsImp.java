package com.finalapp.finalapp.Services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finalapp.finalapp.Entity.AppUser;

public class UserDedailsImp implements UserDetails {
   private Long id ; 
   private String username ; 
	private String email;
   @JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDedailsImp(Long id, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
  public static UserDedailsImp build(AppUser appUser){
   List<GrantedAuthority>authorities = appUser.getRoles().stream().map(
      r-> new SimpleGrantedAuthority(r.getRolename().name())).collect(Collectors.toList());
      return new UserDedailsImp(
         appUser.getId(), 
         appUser.getUsername(), 
         appUser.getEmail() , 
         appUser.getPassword(), 
         authorities
      );
  }


   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return username;
   }
   public String getEmail() {
		return email;
	}
   public Long getId() {
		return id;
	}
   @Override
   public boolean isAccountNonExpired() {
      return true;
   }

   @Override
   public boolean isAccountNonLocked() {
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
   @Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
         UserDedailsImp user = (UserDedailsImp) o;
		return Objects.equals(id, user.id);
	}

   
}

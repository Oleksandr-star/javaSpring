package com.Baranov.demo.fleamarket.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
public class AppUser  { //implements UserDetails

    @Id
    private String id;

    private String username;
    private String password;
    private List<String> roles;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                .collect(Collectors.toList());
//    }

     public String getUsername() { return username; }
     public String getPassword() { return password; }

     public boolean isAccountNonExpired() { return true; }
     public boolean isAccountNonLocked() { return true; }
     public boolean isCredentialsNonExpired() { return true; }
     public boolean isEnabled() { return true; }
}

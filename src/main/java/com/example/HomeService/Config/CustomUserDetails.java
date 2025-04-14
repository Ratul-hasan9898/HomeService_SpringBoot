package com.example.HomeService.Config;

import org.apache.catalina.User;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.HomeService.Entity.UserSeInfo;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private final UserSeInfo user;

    public CustomUserDetails(UserSeInfo user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() { return user.getPassowrd(); }

    @Override
    public String getUsername() { return user.getUserName(); }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}

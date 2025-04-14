package com.example.HomeService.Config;

// security/CustomUserDetailsService.java
//package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.HomeService.Entity.UserSeInfo;
import com.example.HomeService.Repo.UserSeRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSeRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserSeInfo user = repo.findByUserName(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return new CustomUserDetails(user);
    }
}


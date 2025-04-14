package com.example.HomeService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HomeService.Entity.UserSeInfo;
import java.util.List;

@Repository
public interface UserSeRepo extends JpaRepository<UserSeInfo , Integer> {
   public UserSeInfo  findByUserName(String userName);
    
} 
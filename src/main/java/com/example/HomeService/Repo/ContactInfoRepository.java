package com.example.HomeService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.HomeService.Entity.*;


@Repository
public interface ContactInfoRepository extends JpaRepository<contactinfo, Integer> {

}
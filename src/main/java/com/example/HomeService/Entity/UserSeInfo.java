package com.example.HomeService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserSeInfo {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String UserName;
private String Passowrd;
private String Role;
}

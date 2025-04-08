package com.example.HomeService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
public class contactinfo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name ;
private int number;
private String email;
private String message;

}

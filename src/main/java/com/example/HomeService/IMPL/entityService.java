package com.example.HomeService.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HomeService.Entity.contactinfo;
import com.example.HomeService.Repo.ContactInfoRepository;

@Service
public class entityService {
    @Autowired
    private ContactInfoRepository conrefo;
    public contactinfo Cntacsave(contactinfo Cont){
     contactinfo contacINFo=conrefo.save(Cont);
     return contacINFo;
    
    }
    
    public List<contactinfo> findallinfo(){
        return conrefo.findAll();
    }
    public List<contactinfo> findbyid(int id){
         return (List<contactinfo>) conrefo.findById(id).get();
    }
}


package com.example.HomeService.Config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.HomeService.Entity.contactinfo;
import com.example.HomeService.IMPL.entityService;


import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {
    @Autowired
    private entityService Entityse;
  
    @GetMapping("/")
    public String index() {
        return "index";  // This will render index.html (Thymeleaf or JSP depending on your config)
    }

    @GetMapping("/service")
    public String homeService() {
        return "service";
    }

    @GetMapping("/about")
    public String aboutUs() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactUs() {
        return "contact";
    }
  
    @PostMapping("/saveinfo")
    public String saveData(@ModelAttribute contactinfo contact) {
        Entityse.Cntacsave(contact);
      //return new ResponseEntity<>("",HttpStatus.CREATED);
      return "redirect:/about";
    }
    @GetMapping("/showinfo")
    public String showinfo(org.springframework.ui.Model m){
        List<contactinfo> confo = Entityse.findallinfo();
        m.addAttribute("ratul", confo);
       return "showinfo";
    }
    @GetMapping("/showbyid")
    public String showbyid(@PathVariable("showbyid") int i ,org.springframework.ui.Model me){
        List<contactinfo> l1 = Entityse.findbyid(i);
        me.addAttribute("rohim", l1);
        return "redirect:/showinfo";
    }

    
    
}

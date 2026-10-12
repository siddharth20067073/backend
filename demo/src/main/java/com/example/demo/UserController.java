package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController 
{
   @Autowired
   UserRepository ur;

   @GetMapping("/h")
   String m1()
   {
    return "hey";
   }
//http://localhost:8080/register?username=charan&email=charan123%40gmail.com&psw=ayaan
   @GetMapping("/reg")
   String m2()
   {
    return "reg";
   }

   @GetMapping("/getdata")
   ResponseEntity<?> getData(@RequestParam String username)
   //  ResponseEntity<?> getData(@PathVariable String name)
   {
      Users eu=this.ur.findByUsername(username);
      if(eu==null)
      {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid username");
      }
      else
      {
         return ResponseEntity.status(HttpStatus.OK).body(eu);
      }

   }
   @GetMapping("/getalldata")
   ResponseEntity<List<Users>> getAllData()
   {
      List<Users> eu=this.ur.findAll();
      return ResponseEntity.status(HttpStatus.OK).body(eu);
   }

   @PostMapping("/register")
   String m3(@RequestBody Users u)
   {
      Users eu=this.ur.findByUsername(u.username);
      if(eu==null)
      {
              this.ur.save(u);
              return "registration done";
      }
      else
      {
           return "username invalid";
      }
      // Users u=new Users();
      // u.username=username;
      // u.email=email;
      // u.password=psw;
     

      // m.addAttribute("uname",username);
      // m.addAttribute("mail",email);
      // m.addAttribute("password", psw);
     
   }
   @PostMapping("/login")
   ResponseEntity<?> m4(@RequestBody LoginData l)
   {
     Users eu=this.ur.findByUsername(l.username);
     if(eu!=null && eu.password.equals(l.password))
     {
        //return "login done";
        return ResponseEntity.status(HttpStatus.OK).body(eu);
     }
     else
     {
         //return "invalid data";
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid data");
     }
   }

   @PostMapping("/update")
   ResponseEntity<?> m5(@RequestBody UpdatePassword up)
   {
       Users eu=this.ur.findByUsername(up.username);
     if(eu!=null && eu.password.equals(up.password))
     {
         eu.password=up.npassword;
         this.ur.save(eu);
        //return "login done";
        return ResponseEntity.status(HttpStatus.OK).body(eu);
     }
     else
     {
         //return "invalid data";
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid data");
     }
   }

   @PostMapping("/delete")
   ResponseEntity<?> m6(@RequestBody DeleteData dd)
   {
     Users eu=this.ur.findByUsername(dd.username);
     if(eu!=null && eu.password.equals(dd.password))
     {
        this.ur.delete(eu);
        //return "login done";
        return ResponseEntity.status(HttpStatus.OK).body(eu);
     }
     else
     {
         //return "invalid data";
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid data");
     }
   }



}

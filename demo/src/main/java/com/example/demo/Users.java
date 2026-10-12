package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int xyz;

    String username;
    String email;
    String password;

   public void setUsername(String uname)
    {
        this.username=uname;
    }
   public  void setEmail(String mail)
    {
        this.email=mail;
    }
   public void setPassword(String psw)
    {
        this.password=psw;
    }
   public String getUsername()
    {
        return this.username;
    }
   public String getEmail()
    {
        return this.email;
    }
      public  String getPassword()
    {
        return this.password;
    }
}

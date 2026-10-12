package com.example.demo;

import java.util.ArrayList;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer>
{
    Users findByUsername(String name);
}


//  class UserRepositoryImpl implements UserRepository
//  {
//     public static void main(String[] args) {
//        UserRepository ur=new UserRepositoryImpl();
//        ur.save(u);
//     }
//  }



// interface A 
// {
//    void m1(){}
//    public void m2();
//    void m3();
// }
// class B implements A
// {
//    public void m2(){}
//    public void m3(){}
//     public static void main(String[] args) 
//     {
//       //List<Integer> al=new ArrayList<>();
//        A b=new B();
//        b.m1();
//     }
// }
// class C implements A
// {
//     public void m2(){}
//     public void m3(){}
//     public static void main(String[] args) {
//        A c=new C();
//        A b=new B();
//     }
// }





// class A
// {
//     void m1(){}
// }
// class B extends A
// {
//     void m2(){}
//     public static void main(String[] args) {
//        B a=new B();
//        a.m2();
//     }
// }
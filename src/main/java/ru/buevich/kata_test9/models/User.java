package ru.buevich.kata_test9.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "last_name")
   private String last_name;

   @Column(name = "email")
   private String email;


   public User() {}
   
   public User(String name, String last_name, String email) {
      this.name = name;
      this.last_name = last_name;
      this.email = email;
   }

   public Long getId() { return id; }

   public void setId(Long id) { this.id = id; }

   public String getName() { return name; }

   public void setName(String name) { this.name = name; }

   public String getLast_name() { return last_name; }

   public void setLast_name(String last_name) { this.last_name = last_name; }

   public String getEmail() { return email; }

   public void setEmail(String email) { this.email = email; }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", last_name='" + last_name + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}

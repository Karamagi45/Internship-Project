package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class users {

   private Integer user_id ;
   private String full_name;
   private  String  email;
   private String password;
   private String confirm_password;
   private String role;
   private Integer phone;

}

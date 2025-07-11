package com.internship2025.changemanagementsystem.Modal;

import lombok.Data;

@Data
public class change_detail {
   private Integer change_request_id;
   private String source_of_change ;
   private String  type_of_change ;
   private String request_by ;
   private String client_name ;
   private String cost_implementation  ;
   private String change_description_objection;

}

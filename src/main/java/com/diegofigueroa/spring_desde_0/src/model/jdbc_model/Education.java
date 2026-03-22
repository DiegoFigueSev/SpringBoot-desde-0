package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Education {
    /*
    CREATE TABLE educations (
      id SERIAL PRIMARY KEY ,
      degree VARCHAR(255) NOT NULL ,
      description TEXT,
      CONSTRAINT fk_education_personal_indo
                            FOREIGN KEY (personal_info_id)
                            REFERENCES personal_info(id)
                            ON DELETE CASCADE
    );
     */
   private Long id;
   private String degree;
   private String description;
   private Long personalInfoId;
}

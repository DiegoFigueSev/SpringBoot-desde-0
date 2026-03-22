package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class Experience {
    /*
    id SERIAL PRIMARY KEY ,
    job_title VARCHAR(255) NOT NULL ,
    company_name VARCHAR(255) NOT NULL ,
    description TEXT,
    CONSTRAINT fk_experience_personal_info
                         FOREIGN KEY (personal_info_id)
                         REFERENCES personal_info(id)
                         ON DELETE CASCADE
     */
    private Long id;
    private String jobTitle;
    private String companyName;
    private String description;
    private Long personalInfoId;
}

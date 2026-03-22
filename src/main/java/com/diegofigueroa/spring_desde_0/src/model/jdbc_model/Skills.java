package com.diegofigueroa.spring_desde_0.src.model.jdbc_model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Skills {
    /*
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL ,
    level INT,
    CONSTRAINT fk_skill_personal_info
                    FOREIGN KEY (personal_info_id)
                    REFERENCES personal_info(id)
                    ON DELETE CASCADE
     */
    private Long id;
    private String name;
    private Integer level;
    private Long personalInfoId;
}

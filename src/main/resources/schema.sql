DROP TABLE IF EXISTS experiences;
DROP TABLE IF EXISTS educations;
DROP TABLE IF EXISTS skills;
DROP TABLE IF EXISTS personal_info;

CREATE TABLE personal_info (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL ,
    title VARCHAR(255) NOT NULL ,
    profile_description TEXT NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE skills (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL ,
    level INT,
    personal_info_id BIGINT NOT NULL ,
    CONSTRAINT fk_skill_personal_info
                    FOREIGN KEY (personal_info_id)
                    REFERENCES personal_info(id)
                    ON DELETE CASCADE
);

CREATE TABLE educations (
  id SERIAL PRIMARY KEY ,
  degree VARCHAR(255) NOT NULL ,
  description TEXT,
  personal_info_id BIGINT NOT NULL ,
  CONSTRAINT fk_education_personal_indo
                        FOREIGN KEY (personal_info_id)
                        REFERENCES personal_info(id)
                        ON DELETE CASCADE
);

CREATE TABLE experiences (
    id SERIAL PRIMARY KEY ,
    job_title VARCHAR(255) NOT NULL ,
    company_name VARCHAR(255) NOT NULL ,
    description TEXT,
    personal_info_id BIGINT NOT NULL ,
    CONSTRAINT fk_experience_personal_info
                         FOREIGN KEY (personal_info_id)
                         REFERENCES personal_info(id)
                         ON DELETE CASCADE
);

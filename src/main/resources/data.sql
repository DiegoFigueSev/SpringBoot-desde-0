-- CREATE TABLE personal_info (
--     id SERIAL PRIMARY KEY,
--     first_name VARCHAR(100) NOT NULL,
--     last_name VARCHAR(100) NOT NULL ,
--     title VARCHAR(255) NOT NULL ,
--     profile_description TEXT NOT NULL
-- );
INSERT INTO personal_info(first_name, last_name, title, profile_description)
VALUES
      ('Diego', 'Figueroa', 'Ing. Desarrollo de software', 'Ingeniero en desarrollo de software graduado de JALASOFT, programador fullstack');

-- CREATE TABLE skills (
--     id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL ,
--     level INT,
--     personal_info_id BIGINT NOT NULL ,
--     CONSTRAINT fk_skill_personal_info
--                     FOREIGN KEY (personal_info_id)
--                     REFERENCES personal_info(id)
--                     ON DELETE CASCADE
-- );
INSERT INTO skills(name, level, personal_info_id)
VALUES
    ('Java', 5, 1),
    ('SpringBoot', 5, 1),
    ('Python', 5, 1),
    ('FastAPI', 4, 1),
    ('Typescript', 3, 1),
    ('React', 3, 1);

-- CREATE TABLE educations (
--   id SERIAL PRIMARY KEY ,
--   degree VARCHAR(255) NOT NULL ,
--   description TEXT,
--   personal_info_id BIGINT NOT NULL ,
--   CONSTRAINT fk_education_personal_indo
--                         FOREIGN KEY (personal_info_id)
--                         REFERENCES personal_info(id)
--                         ON DELETE CASCADE
-- );

INSERT INTO educations(degree, description, personal_info_id)
VALUES
    ('Ingenieria', 'Ingenieria en desarrollo de software', 1);

-- CREATE TABLE experiences (
--     id SERIAL PRIMARY KEY ,
--     job_title VARCHAR(255) NOT NULL ,
--     company_name VARCHAR(255) NOT NULL ,
--     description TEXT,
--     personal_info_id BIGINT NOT NULL ,
--     CONSTRAINT fk_experience_personal_info
--                          FOREIGN KEY (personal_info_id)
--                          REFERENCES personal_info(id)
--                          ON DELETE CASCADE
-- );
INSERT INTO experiences(job_title, company_name, description, personal_info_id)
VALUES
    ('Analista en automatizacion', 'CBN', 'Analista en automatizacion enfocado en el desarrollo de solucioens novedosas', 1),
    ('Freelance', 'Independiente', 'Desarrollador de soluciones para tiendas locales de cochabamba', 1);

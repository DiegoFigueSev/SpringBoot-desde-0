package com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//* Qque hace el repository?
//* Con este decorador, le decimos a SPRINGBOOT que esta clase se comunicara con la db
//? Permite que spring lo gestioen automaticamente (inyeccion de dependencia)
//? Traduce los errores de la base de datos a exceptiones de Spring
@Repository //* BEAN del tipo REPOSITORY
@Primary //* Si tenemos varios repositorios q implementen la misma interface lo marcamos a este como principal para q lo use
@RequiredArgsConstructor
public class PersonalRepositoryImpl implements IPersonalInfoRepository{

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<PersonalInfo> mapper = (rs, numRow) -> {
        var info = new PersonalInfo();
        info.setId(rs.getLong("id"));
        info.setFirstName(rs.getString("first_name"));
        info.setLastName(rs.getString("last_name"));
        info.setTitle(rs.getString("title"));
        info.setProfileDescription(rs.getString("profile_description"));
        info.setEmail(rs.getString("email"));
        return info;
    };

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        if (personalInfo.getId() == null){
            String sql = """
                INSERT INTO personal_info(first_name, last_name, title, profile_description, email)
                VALUES
                      (?, ?, ?, ?, ?);
            """;
            jdbcTemplate.update(
                        sql,
                        personalInfo.getFirstName(), personalInfo.getLastName(), personalInfo.getTitle(), personalInfo.getProfileDescription(), personalInfo.getEmail()
                    );
        } else {
            String sql = """
                UPDATE personal_info
                SET first_name = ? , last_name = ? , title = ?, profile_description = ?, email=?
                WHERE id=?
            """;
            jdbcTemplate.update(
                    sql,
                    personalInfo.getFirstName(), personalInfo.getLastName(), personalInfo.getTitle(), personalInfo.getProfileDescription(), personalInfo.getEmail() ,personalInfo.getId()
            );
        }
        return findAll().getLast();
    }

    @Override
    public Optional<PersonalInfo> findById(long id) {
        String sql = "SELECT * FROM personal_info WHERE id=?";
        try {
            // * Esta busqueda tiene 3 resultados: q encuentre uno, que no encuentre nada, que encuentre muchos.
            //? El query for object retorna un unico resultado
            //? Si da por resultado muchas filas, nos dara un exception
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, mapper, id));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public List<PersonalInfo> findAll() {
        String sql = "SELECT * FROM personal_info";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE from personal_info WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

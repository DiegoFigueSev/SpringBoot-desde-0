package com.diegofigueroa.spring_desde_0.src.repository.jdbc_repository;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Primary
public class SkillRepositoryImpl implements ISkillRepository{

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Skill> mapper = (rs, numRow) -> {
        var skill = new Skill();
        skill.setId(rs.getLong("id"));
        skill.setName(rs.getString("name"));
        skill.setLevel(rs.getInt("level"));
        skill.setPersonalInfoId(rs.getLong("personal_info_id"));
        return skill;
    };

    @Override
    public Skill save(Optional<Skill> skill) {
        if (skill.isEmpty()) return null;
        String query = """
        INSERT INTO skills(name, level, personal_info_id)
        VALUES (? , ?, ?)
        """;
        var skillAux = skill.get();
        jdbcTemplate.update(query, skillAux.getName(), skillAux.getLevel(), skillAux.getPersonalInfoId());
        return skillAux;
    }

    @Override
    public Optional<Skill> getById(long id) {
        String query = """
                SELECT * FROM skills
                WHERE id=?
                """;
        var entity = Optional.ofNullable(jdbcTemplate.queryForObject(query, mapper, id));
        return entity;
    }

    @Override
    public List<Skill> getAll(Optional<Long> id) {
        String query = id.isPresent()
                ? "SELECT * FROM skills WHERE personal_info_id=?"
                : "SELECT * FROM skills";
        return id
                .map(aLong -> jdbcTemplate.query(query, mapper, aLong))
                .orElseGet(() -> jdbcTemplate.query(query, mapper));
    }

    @Override
    public void delete(long id) {
        String query = "DELETE * FROM skills WHERE id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Skill update(Skill skill) {
        String query = """
        UPDATE skills
        SET name=?, level=?, personal_info_id=?
        WHERE id=?
        """;
        jdbcTemplate.update(query, skill.getName(), skill.getLevel(), skill.getPersonalInfoId(), skill.getId());
        return skill;
    }
}

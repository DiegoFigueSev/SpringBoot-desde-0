package com.diegofigueroa.spring_desde_0.src.controler.jdbc_controller;

import com.diegofigueroa.spring_desde_0.src.model.jdbc_model.Skill;
import com.diegofigueroa.spring_desde_0.src.service.jdbc_service.ISkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/skill")
public class SkillController {
    private final ISkillService service;

    @PostMapping
    public ResponseEntity<Skill> create(@RequestBody Skill skill){
        return ResponseEntity.ok(service.save(Optional.ofNullable(skill)));
    }

    @GetMapping
    public List<Skill> getAll(@RequestParam(required = false) Long userId){
        return service.getAll(Optional.ofNullable(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getById(@PathVariable Long id){
        var skill = service.getById(id);
        if (skill.isPresent()) return ResponseEntity.ok(skill.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Elemento no encontrado");

    }

    @PatchMapping()
    public ResponseEntity<Skill> update(@RequestBody Skill skill){
        return ResponseEntity.ok(service.update(skill));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}

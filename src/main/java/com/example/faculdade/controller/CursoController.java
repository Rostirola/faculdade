package com.example.faculdade.controller;

import com.example.faculdade.model.Curso;
import com.example.faculdade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() {
        return cursoService.findAll();
    }

    @PostMapping
    public Curso cadastrar(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        cursoService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) {
        return cursoService.findById(id);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@RequestBody Curso curso) {
        return cursoService.update(curso);
    }

    @GetMapping("/sem-cache")
    public List<Curso> listarCursos() {
        return cursoService.findAllSemCache();
    }

}

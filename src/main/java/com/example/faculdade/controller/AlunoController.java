package com.example.faculdade.controller;

import com.example.faculdade.model.Aluno;
import com.example.faculdade.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.findAll();
    }

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        alunoService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return alunoService.findById(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@RequestBody Aluno aluno) {
        return alunoService.update(aluno);
    }

}

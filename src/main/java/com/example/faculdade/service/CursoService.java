package com.example.faculdade.service;

import com.example.faculdade.model.Curso;
import com.example.faculdade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Cacheable(value="cursos")
    public List<Curso> findAll() {
        long start = System.currentTimeMillis();
        List<Curso> cursos = cursoRepository.findAll();
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Com Cache: " + diff);
        return cursos;
    }

    @Cacheable(value="cursos", key = "#id")
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @CacheEvict(value="cursos", key = "#id")
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @CacheEvict(value="cursos", key = "#id")
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    @CacheEvict(value="cursos", key = "#id")
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> findAllSemCache() {
        long start = System.currentTimeMillis();
        List<Curso> cursos = cursoRepository.findAll();
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("Sem Cache: " + diff);
        return cursos;
    }
}

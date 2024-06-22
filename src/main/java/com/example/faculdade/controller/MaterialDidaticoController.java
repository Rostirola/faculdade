package com.example.faculdade.controller;

import com.example.faculdade.model.MaterialDidatico;
import com.example.faculdade.service.MaterialDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MaterialDidatico")
public class MaterialDidaticoController {

    @Autowired
    private MaterialDidaticoService materialDidaticoService;

    @GetMapping
    public List<MaterialDidatico> findAll() {
        return materialDidaticoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MaterialDidatico> findById(String id) {
        return materialDidaticoService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody MaterialDidatico materialDidatico) {
        materialDidaticoService.save(materialDidatico);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody MaterialDidatico materialDidatico) {
        materialDidaticoService.update(id, materialDidatico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        materialDidaticoService.delete(id);
    }
}

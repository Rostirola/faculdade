package com.example.faculdade.service;

import com.example.faculdade.model.MaterialDidatico;
import com.example.faculdade.repository.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {

    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public List<MaterialDidatico> findAll() {
        return materialDidaticoRepository.findAll();
    }

    public Optional<MaterialDidatico> findById(String id) {
        return materialDidaticoRepository.findById(id);
    }

    public void save(MaterialDidatico materialDidatico) {
        materialDidaticoRepository.save(materialDidatico);
    }

    public void delete(String id) {
        materialDidaticoRepository.deleteById(id);
    }

    public MaterialDidatico update(String id, MaterialDidatico newMaterialDidatico) {
        return materialDidaticoRepository.findById(id).map(materialDidatico -> {
            materialDidatico.setTitulo(newMaterialDidatico.getTitulo());
            materialDidatico.setConteudo(newMaterialDidatico.getConteudo());
            return materialDidaticoRepository.save(materialDidatico);
        }).orElseGet(() -> {
            newMaterialDidatico.setId(id);
            return materialDidaticoRepository.save(newMaterialDidatico);
        });
    }
}

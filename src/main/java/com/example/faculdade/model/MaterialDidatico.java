package com.example.faculdade.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materiais_didaticos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialDidatico {
    @Id
    private String id;
    private String titulo;
    private String conteudo;
}
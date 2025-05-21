
package com.senac.pi_industria_quimica.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Table(name="Produto")
@Component

public class Produto {
  @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    private String nome;
    private String lote;
    private String descricao;
    private String pH;  
    private String concentracao;
}


package com.senac.pi_industria_quimica.service;

import com.senac.pi_industria_quimica.model.Materia_Prima;
import com.senac.pi_industria_quimica.repository.Materia_PrimaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class Materia_PrimaService {
   @Autowired
    private Materia_PrimaRepository mpRepository;
    
    public Materia_Prima salvar(Materia_Prima materia_prima) {
        return mpRepository.save(materia_prima);
    }
    
    public List<Materia_Prima> listarTodos() {
        return mpRepository.findAll();
    }
    
    public Materia_Prima buscarPorId(int id) {
        return mpRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id) {
        mpRepository.deleteById(id);
    } 
}

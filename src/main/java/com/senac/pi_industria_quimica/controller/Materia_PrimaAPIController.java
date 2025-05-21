
package com.senac.pi_industria_quimica.controller;

import com.senac.pi_industria_quimica.model.Materia_Prima;
import com.senac.pi_industria_quimica.service.Materia_PrimaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materia_prima")
@CrossOrigin(origins= "*")

public class Materia_PrimaAPIController {
    @Autowired
    private Materia_PrimaService mpService;
    
    @GetMapping
    public List<Materia_Prima> listarTodos() {
        return mpService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Materia_Prima buscarMP(@PathVariable int id) {
        return mpService.buscarPorId(id);
    }
    
    @PostMapping
    public Materia_Prima criarMP(@RequestBody Materia_Prima materia_prima) {
        return mpService.salvar(materia_prima);
    }
    
    @PutMapping("/{id}")
    public Materia_Prima atualizarMP(@PathVariable int id, @RequestBody Materia_Prima mpAtualizada) {
        return mpService.salvar(mpAtualizada);
    }
    
    @DeleteMapping("/{id}")
    public void deletarMP(@PathVariable int id) {
        mpService.excluir(id);
    } 
}

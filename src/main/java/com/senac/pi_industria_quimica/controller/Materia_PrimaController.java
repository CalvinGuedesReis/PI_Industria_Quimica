
package com.senac.pi_industria_quimica.controller;

import com.senac.pi_industria_quimica.model.Materia_Prima;
import com.senac.pi_industria_quimica.service.Materia_PrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materia_prima")

public class Materia_PrimaController {
    @Autowired
    private Materia_PrimaService mpService;
   
    @Autowired
    
    @GetMapping("/cadastro_mp")
    public String exibirFormulario(Model model) {
        model.addAttribute("materia_prima", new Materia_Prima());
        return "cadastroMP";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Materia_Prima materia_prima) {
        mpService.salvar(materia_prima);
        return "redirect:/materia_prima/lista";
    }
    
    @GetMapping("/lista_mp")
    public String lista(Model model) {
        model.addAttribute("materia_prima", mpService.listarTodos());
        return "listagemMP";
    }
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, Model model) {
        model.addAttribute("materia_prima", mpService.buscarPorId(id));
        return "cadastroMP";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        mpService.excluir(id);
        return "redirect:/materia_prima/lista";
    }
    
    @GetMapping("/detalhesMP/{id}")
    public String exibirDetalhes(@PathVariable int id, Model model) {
        Materia_Prima materia_prima = mpService.buscarPorId(id);
        
        model.addAttribute("materia_prima", materia_prima);
        return "detalhesMP";
    }   
}

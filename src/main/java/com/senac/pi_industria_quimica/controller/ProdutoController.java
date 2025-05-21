
package com.senac.pi_industria_quimica.controller;

import com.senac.pi_industria_quimica.model.Produto;
import com.senac.pi_industria_quimica.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")

public class ProdutoController {
 @Autowired
    private ProdutoService produtoService;
   
    @Autowired
    
    @GetMapping("/cadastro_produto")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastroProduto";
    }
    
    @PostMapping("/gravar")
    public String processarFormulario(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produto/lista";
    }
    
    @GetMapping("/lista_produto")
    public String lista(Model model) {
        model.addAttribute("produto", produtoService.listarTodos());
        return "listagemProduto";
    }
    
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable int id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        return "cadastroProduto";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        produtoService.excluir(id);
        return "redirect:/produto/lista";
    }
    
    @GetMapping("/detalhesProduto/{id}")
    public String exibirDetalhes(@PathVariable int id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        
        model.addAttribute("produto", produto);
        return "detalhesProduto";
    }   
}


package com.senac.pi_industria_quimica.service;

import com.senac.pi_industria_quimica.model.Produto;
import com.senac.pi_industria_quimica.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }
    
    public Produto buscarPorId(int id) {
        return produtoRepository.findById(id).orElse(null);
    }
    
    public void excluir(int id) {
        produtoRepository.deleteById(id);
    }
}



package com.senac.pi_industria_quimica.repository;

import com.senac.pi_industria_quimica.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}

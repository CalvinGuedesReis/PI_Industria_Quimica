
package com.senac.pi_industria_quimica.repository;

import com.senac.pi_industria_quimica.model.Materia_Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Materia_PrimaRepository extends JpaRepository<Materia_Prima, Integer>{
    
}

package edu.com.br.gerenciamentoDeTurmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.com.br.gerenciamentoDeTurmas.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}

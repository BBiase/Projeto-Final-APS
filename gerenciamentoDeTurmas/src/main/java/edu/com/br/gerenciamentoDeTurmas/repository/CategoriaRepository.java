package edu.com.br.gerenciamentoDeTurmas.repository;

import edu.com.br.gerenciamentoDeTurmas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

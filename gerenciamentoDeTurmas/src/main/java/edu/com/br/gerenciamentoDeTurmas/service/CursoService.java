package edu.com.br.gerenciamentoDeTurmas.service;

import edu.com.br.gerenciamentoDeTurmas.model.Curso;
import edu.com.br.gerenciamentoDeTurmas.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso adicionarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}

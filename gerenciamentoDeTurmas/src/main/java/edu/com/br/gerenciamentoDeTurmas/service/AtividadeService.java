package edu.com.br.gerenciamentoDeTurmas.service;

import edu.com.br.gerenciamentoDeTurmas.model.Atividade;
import edu.com.br.gerenciamentoDeTurmas.model.Categoria;
import edu.com.br.gerenciamentoDeTurmas.repository.AtividadeRepository;
import edu.com.br.gerenciamentoDeTurmas.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;
    private final CategoriaRepository categoriaRepository;

    public AtividadeService(AtividadeRepository atividadeRepository, CategoriaRepository categoriaRepository) {
        this.atividadeRepository = atividadeRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Atividade> listarTodas() {
        return atividadeRepository.findAll();
    }

    public Atividade adicionarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public List<Atividade> filtrarPorCategoria(Long categoriaId) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
        if (categoria.isPresent()) {
            return atividadeRepository.findByCategoria(categoria.get());
        } else {
            throw new IllegalArgumentException("Categoria não encontrada");
        }
    }

    public List<Atividade> filtrarPorData(Date startDate, Date endDate) {
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        return atividadeRepository.findByDataBetween(sqlStartDate, sqlEndDate);
    }

    public List<Atividade> filtrarPorCurso(Long cursoId) {
        return atividadeRepository.findByCursoId(cursoId);
    }

    public Atividade salvar(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    public List<Atividade> filtrarPorPublicacao(boolean publicada) {
        return atividadeRepository.findByPublicada(publicada);
    }

    public Atividade publicarAtividade(Long id) {
        Optional<Atividade> atividadeOptional = atividadeRepository.findById(id);
        if (atividadeOptional.isPresent()) {
            Atividade atividade = atividadeOptional.get();
            atividade.setPublicada(true);
            return atividadeRepository.save(atividade);
        } else {
            throw new IllegalArgumentException("Atividade não encontrada");
        }
    }

    public Atividade despublicarAtividade(Long id) {
        Optional<Atividade> atividadeOptional = atividadeRepository.findById(id);
        if (atividadeOptional.isPresent()) {
            Atividade atividade = atividadeOptional.get();
            atividade.setPublicada(false);
            return atividadeRepository.save(atividade);
        } else {
            throw new IllegalArgumentException("Atividade não encontrada");
        }
    }
}

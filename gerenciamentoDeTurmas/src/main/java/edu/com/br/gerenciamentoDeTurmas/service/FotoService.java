package edu.com.br.gerenciamentoDeTurmas.service;

import org.springframework.stereotype.Service;
import edu.com.br.gerenciamentoDeTurmas.model.Atividade;
import edu.com.br.gerenciamentoDeTurmas.model.Foto;
import edu.com.br.gerenciamentoDeTurmas.repository.AtividadeRepository;
import edu.com.br.gerenciamentoDeTurmas.repository.FotoRepository;
import java.util.List;

@Service
public class FotoService {
    private final FotoRepository fotoRepository;
    private final AtividadeRepository atividadeRepository;

    public FotoService(FotoRepository fotoRepository, AtividadeRepository atividadeRepository) {
        this.fotoRepository = fotoRepository;
        this.atividadeRepository = atividadeRepository;
    }

    public Foto adicionarFoto(Long atividadeId, Foto foto) {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new RuntimeException("Atividade não encontrada"));

        foto.setAtividade(atividade);
        return fotoRepository.save(foto);
    }

    public List<Foto> listarTodas() {
        return fotoRepository.findAll();
    }
}

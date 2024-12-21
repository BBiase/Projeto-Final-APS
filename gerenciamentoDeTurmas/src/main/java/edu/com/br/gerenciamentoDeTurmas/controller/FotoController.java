package edu.com.br.gerenciamentoDeTurmas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.com.br.gerenciamentoDeTurmas.model.Foto;
import edu.com.br.gerenciamentoDeTurmas.service.FotoService;

import java.util.List;

@RestController
@RequestMapping("/fotos")
@Tag(name = "Fotos", description = "Gerenciamento de Fotos")
public class FotoController {
    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as fotos", description = "Retorna uma lista de todas as fotos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de fotos encontrada"),
            @ApiResponse(responseCode = "404", description = "Fotos não encontradas")
    })
    public List<Foto> listarFotos() {
        return fotoService.listarTodas();
    }

    @PostMapping("/{atividadeId}")
    @Operation(summary = "Adicionar uma nova foto", description = "Adiciona uma nova foto a uma atividade")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foto adicionada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Atividade não encontrada")
    })
    public ResponseEntity<Foto> adicionarFoto(@PathVariable Long atividadeId, @RequestBody Foto foto) {
        Foto novaFoto = fotoService.adicionarFoto(atividadeId, foto);
        return ResponseEntity.ok(novaFoto);
    }
}

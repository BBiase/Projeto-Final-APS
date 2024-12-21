package edu.com.br.gerenciamentoDeTurmas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.com.br.gerenciamentoDeTurmas.model.Curso;
import edu.com.br.gerenciamentoDeTurmas.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Gerenciamento de Cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os cursos", description = "Retorna uma lista de todos os cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de cursos encontrada"),
            @ApiResponse(responseCode = "404", description = "Cursos não encontrados")
    })
    public List<Curso> listarCursos() {
        return cursoService.listarTodos();
    }

    @PostMapping
    @Operation(summary = "Adicionar um novo curso", description = "Adiciona um novo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso adicionado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos para o curso")
    })
    public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.adicionarCurso(curso);
        return ResponseEntity.status(201).body(novoCurso);
    }
}

package br.com.oracle.controller;

import br.com.oracle.entity.Participante;
import br.com.oracle.repository.ParticipanteRepository;
import br.com.oracle.service.ParticipanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/participantes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ParticipanteController {

    private final ParticipanteService service;

    @PostMapping
    @Operation(summary = "endpoint responsável por cadastrar participante.")
    @ApiResponse(responseCode = "201", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Participante>cadastrarParticipante(@RequestBody @Valid Participante participante){
        var cadastrar = service.cadastrarParticipante(participante);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(cadastrar);
    }

    @GetMapping
    @Operation(summary = "endpoint responsável por listar.")
    @ApiResponse(responseCode = "200", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Page<Participante>>listarParticipantes(Pageable pageable){
        Page<Participante> participantes = service.listarParticipantes(pageable);
        return ResponseEntity.ok(participantes);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "endpoint responsável por excluir.")
    @ApiResponse(responseCode = "204", description = " success", content = {
            @Content(mediaType = "application.json", schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirParticipante(@PathVariable Long id){
        service.excluirParticipante(id);
        return ResponseEntity.noContent().build();
    }
}

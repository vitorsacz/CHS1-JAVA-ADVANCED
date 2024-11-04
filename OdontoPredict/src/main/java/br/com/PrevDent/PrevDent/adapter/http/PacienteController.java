package br.com.PrevDent.PrevDent.adapter.http;

import br.com.PrevDent.PrevDent.adapter.http.dto.request.PacienteCreateRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.PacienteUpdateRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.mapper.PacienteDtoMapper;
import br.com.PrevDent.PrevDent.domain.model.Paciente;
import br.com.PrevDent.PrevDent.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteDtoMapper pacienteDtoMapper;

    @Operation(summary = "Cadastrar um novo paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação na requisição")
    })
    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody @Valid PacienteCreateRequest pacienteDto) {

        Paciente paciente = pacienteDtoMapper.converterPacienteDto(pacienteDto);

        pacienteService.cadastarPaciente(paciente);
        return ResponseEntity.ok(paciente);
    }

    @Operation(summary = "Listar todos os pacientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes retornada com sucesso")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @Operation(summary = "Atualizar um paciente existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "400", description = "Erro de validação na requisição")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable String id, @RequestBody @Valid PacienteUpdateRequest pacienteUpdateDtoDto) {

        Paciente paciente = pacienteDtoMapper.converterPacienUpdateteDto(pacienteUpdateDtoDto);

        Optional<Paciente> atualizado = pacienteService.atualizarPaciente(id, paciente);
        if (atualizado.isPresent()) {
            return ResponseEntity.ok(atualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Buscar um paciente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable String id) {
        Paciente paciente = pacienteService.buscarPaciente(id);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Deletar um paciente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Paciente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Paciente> deletarPaciente(@PathVariable String id) {
        boolean deletado = pacienteService.excluirPaciente(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

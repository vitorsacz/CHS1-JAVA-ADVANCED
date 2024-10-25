package br.com.OdontoPredict.OdontoPredict.adapter.http;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.request.PacienteCreateRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.request.PacienteUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper.PacienteDtoMapper;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
import br.com.OdontoPredict.OdontoPredict.domain.service.PacienteService;
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

    @PostMapping
    public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody @Valid PacienteCreateRequest pacienteDto) {

        Paciente paciente = pacienteDtoMapper.converterPacienteDto(pacienteDto);

        pacienteService.cadastarPaciente(paciente);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listarPacientes() {
        List<Paciente> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

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

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPacientePorId(@PathVariable String id) {
        Paciente paciente = pacienteService.buscarPaciente(id);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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

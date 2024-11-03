package br.com.PrevDent.PrevDent.adapter.http;


import br.com.PrevDent.PrevDent.adapter.http.dto.mapper.ConsultaDtoMapper;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.ConsultaCreatRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.ConsultaUpdateRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.response.ConsultaListaResponse;
import br.com.PrevDent.PrevDent.domain.model.Consulta;
import br.com.PrevDent.PrevDent.domain.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private ConsultaDtoMapper consultaDtoMapper;

    @PostMapping
    public ResponseEntity<Consulta> cadastrarConsulta(@RequestBody @Valid ConsultaCreatRequest consultaCreateRequest) {
        Consulta consulta = consultaDtoMapper.criandoDtoParaConsulta(consultaCreateRequest);

        consultaService.cadastrarConsulta(consulta);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Consulta>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Consulta> atualizarConsulta(@PathVariable String id, @RequestBody @Valid ConsultaUpdateRequest consultaUpdateRequest) {
        Consulta consulta = consultaDtoMapper.converterConsultaUpdateteDto(consultaUpdateRequest);

        Optional<Consulta> consultaAtualizada = consultaService.atualizarConsulta(id, consulta);
        if (consultaAtualizada.isPresent()) {
            return ResponseEntity.ok(consultaAtualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarConsultaPorID(@PathVariable String id) {
        Consulta consulta = consultaService.buscarConsulta(id);

        if (consulta != null) {
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable String id) {
        boolean deletado = consultaService.excluirConsulta(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

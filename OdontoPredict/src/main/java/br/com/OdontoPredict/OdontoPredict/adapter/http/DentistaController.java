package br.com.OdontoPredict.OdontoPredict.adapter.http;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper.DentistaDtoMapper;
import br.com.OdontoPredict.OdontoPredict.adapter.http.request.DentistaCreatRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.request.DentistaUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.domain.model.Dentista;
import br.com.OdontoPredict.OdontoPredict.domain.service.DentistaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @Autowired
    private DentistaDtoMapper dentistaDtoMapper;

    @PostMapping
    public ResponseEntity<Dentista> cadastrarDentista(@RequestBody @Valid DentistaCreatRequest dentistaCreatRequest) {

        Dentista dentista = dentistaDtoMapper.createDentista(dentistaCreatRequest);

        dentistaService.cadastrarDentista(dentista);
        return ResponseEntity.ok(dentista);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listarDentistas() {
        List<Dentista> dentistas = dentistaService.listarDentistas();
        return ResponseEntity.ok(dentistas);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Dentista> atualizarDentista(@PathVariable String id, @RequestBody @Valid DentistaUpdateRequest dentistaUpdateRequest) {

        Dentista dentista = dentistaDtoMapper.converterDentistaUpdateteDto(dentistaUpdateRequest);

        Optional<Dentista> atualiza = dentistaService.atualizarDentista(id, dentista);
        if (atualiza.isPresent()) {
            return ResponseEntity.ok(atualiza.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscarDentistaPorID(@PathVariable String id) {
        Dentista dentista = dentistaService.buscarDentista(id);
        if (dentista != null) {
            return new ResponseEntity<>(dentista, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dentista> deletarDentista(@PathVariable String id) {
        boolean deletado = dentistaService.removerDentista(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

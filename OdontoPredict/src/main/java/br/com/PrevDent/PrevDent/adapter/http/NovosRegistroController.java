package br.com.PrevDent.PrevDent.adapter.http;

import br.com.PrevDent.PrevDent.adapter.http.dto.mapper.NovosRegistroDtoMapper;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.NovosRegistroCreatRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.NovosRegistroUpdateRequest;
import br.com.PrevDent.PrevDent.domain.exception.NovosRegistroNotFoundException;
import br.com.PrevDent.PrevDent.domain.model.NovosRegistro;
import br.com.PrevDent.PrevDent.domain.service.NovosRegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/novos-registros")
public class NovosRegistroController {

    @Autowired
    private NovosRegistroService novosRegistroService;

    @Autowired
    private NovosRegistroDtoMapper novosRegistroDtoMapper;

    @PostMapping("/cadastrar")
    public ResponseEntity<NovosRegistro> cadastrarRegistro(@RequestBody @Valid NovosRegistroCreatRequest novosRegistroCreateRequest) {

        NovosRegistro novosRegistro = novosRegistroDtoMapper.converteCreateNovosRegistro(novosRegistroCreateRequest);

        novosRegistroService.cadastrarRegistro(novosRegistro);
        return ResponseEntity.ok(novosRegistro);
    }

    @GetMapping
    public ResponseEntity<List<NovosRegistro>> listarRegistros() {
        List<NovosRegistro> registros = novosRegistroService.listarRegistros();
        return ResponseEntity.ok(registros);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<NovosRegistro> atualizarRegistro(@PathVariable String id, @RequestBody @Valid NovosRegistroUpdateRequest novosRegistroUpdateRequest) {

        NovosRegistro novosRegistro = novosRegistroDtoMapper.converterNovosRegistroDto(novosRegistroUpdateRequest);

        Optional<NovosRegistro> registroAtualizado = novosRegistroService.atualizarRegistro(id, novosRegistro);

        return registroAtualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRegistro(@PathVariable String id) {
        boolean deletado = novosRegistroService.deletarRegistro(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NovosRegistro> detalharRegistro(@PathVariable String id) {
        try {
            NovosRegistro registro = novosRegistroService.detalharRegistro(id);
            return ResponseEntity.ok(registro);
        } catch (NovosRegistroNotFoundException e) {
            return ResponseEntity.status(e.HTTP_STATUS_CODE).body(null);
        }
    }
}
package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.http.request.DiagnosticoCreateDto;
import br.com.OdontoPredict.OdontoPredict.adapter.http.request.DiagnosticoUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.domain.model.Diagnostico;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticoDtoMapper {

    public Diagnostico converteCreateDiagnostico(DiagnosticoCreateDto diagnosticoCreateDto) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setIdDiagnostico(diagnosticoCreateDto.getIdDiagnostico());
        diagnostico.setDescricao(diagnosticoCreateDto.getDescricao());
        diagnostico.setRecomendacao(diagnosticoCreateDto.getRecomendacao());
        return diagnostico;
    }

    public  Diagnostico converterDiagnosticoDto(DiagnosticoUpdateRequest diagnosticoUpdateRequest) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setDescricao(diagnosticoUpdateRequest.getDescricao());
        diagnostico.setRecomendacao(diagnosticoUpdateRequest.getRecomendacao());
        return diagnostico;
    }
}

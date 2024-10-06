package br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.DentistaEntity;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.DiagnosticoEntity;
import br.com.OdontoPredict.OdontoPredict.domain.model.Dentista;
import br.com.OdontoPredict.OdontoPredict.domain.model.Diagnostico;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticoMapper {

    public DiagnosticoEntity converteDiagnosticoEntity(Diagnostico diagnostico) {
        DiagnosticoEntity diagnosticoEntity = new DiagnosticoEntity();
        diagnosticoEntity.setIdDiagnostico(diagnostico.getIdDiagnostico());
        diagnosticoEntity.setDescricao(diagnostico.getDescricao());
        diagnosticoEntity.setRecomendacao(diagnostico.getRecomendacao());
        return diagnosticoEntity;
    }

    public Diagnostico converteDiagnostico(DiagnosticoEntity diagnosticoEntity) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setIdDiagnostico(diagnosticoEntity.getIdDiagnostico());
        diagnostico.setDescricao(diagnosticoEntity.getDescricao());
        diagnostico.setRecomendacao(diagnosticoEntity.getRecomendacao());
        return diagnostico;
    }

    public Diagnostico converterAtualizacaoDoDiagnostico(DiagnosticoEntity diagnosticoEntity) {
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setIdDiagnostico(diagnosticoEntity.getIdDiagnostico());
        diagnostico.setDescricao(diagnosticoEntity.getDescricao());
        diagnostico.setRecomendacao(diagnosticoEntity.getRecomendacao());
        return diagnostico;
    }

    public void atualizarDiagnosticoEntity(DiagnosticoEntity diagnosticoEntity, Diagnostico diagnostico) {
        diagnosticoEntity.setDescricao(diagnostico.getDescricao());
        diagnosticoEntity.setRecomendacao(diagnostico.getRecomendacao());
    }
}

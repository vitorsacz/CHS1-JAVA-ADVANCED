package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.domain.model.Diagnostico;

import java.util.List;
import java.util.Optional;

public interface DiagnosticoService {

    void cadastrarDiagnostico(Diagnostico diagnostico);

    List<Diagnostico> listarDiagnosticos();

    Optional<Diagnostico> atualizarDiagnostico(String id, Diagnostico diagnostico);

    boolean excluirDiagnostico(String id);

    Diagnostico buscarDiagnostico(String id);
}

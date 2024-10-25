package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.domain.model.Consulta;

import java.util.List;
import java.util.Optional;

public interface ConsultaService {

    void cadastrarConsulta(Consulta consulta);

    List<Consulta> listarConsultas();

    Optional<Consulta> atualizarConsulta(String id, Consulta consulta);

    boolean excluirConsulta(String id);

    Consulta buscarConsulta(String id);
}

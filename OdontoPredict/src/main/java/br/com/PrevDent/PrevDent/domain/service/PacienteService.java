package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    void cadastarPaciente(Paciente paciente);

    List<Paciente> listarPacientes();

    Optional<Paciente> atualizarPaciente(String id, Paciente paciente);

    boolean excluirPaciente(String id);

    Paciente buscarPaciente(String id);

}

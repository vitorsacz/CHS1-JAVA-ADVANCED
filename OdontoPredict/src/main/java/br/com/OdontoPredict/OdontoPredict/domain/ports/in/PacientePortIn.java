package br.com.OdontoPredict.OdontoPredict.domain.ports.in;

public interface PacientePortIn<Entrada, Saida>{

    Saida cadastrarPaciente(Entrada entrada);

    Saida listarPacientes();

    Saida atualizarPaciente(String id, Entrada obj);

    Saida deletarPaciente(String id);

    Saida detalharPaciente(String id);
}

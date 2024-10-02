package br.com.OdontoPredict.OdontoPredict.domain.ports.in;

public interface DentistaPortin<Entrada, Saida> {

    Saida cadastrarDentista(Entrada entrada);

    Saida listarDentistas();

    Saida atualizarDentista(String id, Entrada obj);

    Saida deletarDentista(String id);

    Saida detalharDentista(String id);

}

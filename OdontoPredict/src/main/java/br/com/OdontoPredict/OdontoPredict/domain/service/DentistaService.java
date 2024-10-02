package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.domain.model.Dentista;

import java.util.List;
import java.util.Optional;

public interface DentistaService {

    void cadastrarDentista(Dentista dentista);

    List<Dentista> listarDentistas();

    Optional<Dentista> atualizarDentista(String id, Dentista dentista);

    boolean removerDentista(Dentista dentista);

    Dentista buscarDentista(String id);
}

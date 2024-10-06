package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.Data;
import java.util.UUID;

@Data
public class Paciente {

    private String idPaciente;
    private String nome;
    private String cpf;
    private String dataNascimento;

    public Paciente() {
        this.idPaciente = UUID.randomUUID().toString();
    }
}

package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente {

    private String idPaciente;
    private String nome;
    private String dataNascimento;
}

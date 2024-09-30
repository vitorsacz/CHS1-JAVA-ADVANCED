package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dentista {

    private String idDentista;
    private String nome;
    private String especializacao;
}

package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sinistro {

    private String id;
    private Consulta consulta;
    private String causa;
    private double custo;
}

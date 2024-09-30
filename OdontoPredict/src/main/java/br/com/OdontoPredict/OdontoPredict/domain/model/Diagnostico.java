package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Diagnostico {

    private String idDiagnostico;
    private String descricao;
    private String recomendacao;
}

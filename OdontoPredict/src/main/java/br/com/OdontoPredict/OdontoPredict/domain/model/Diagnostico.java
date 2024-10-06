package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.Data;
import java.util.UUID;


@Data
public class Diagnostico {

    private String idDiagnostico;
    private String descricao;
    private String recomendacao;

}

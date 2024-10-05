package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.Data;
import java.util.UUID;


@Data
public class Sinistro {

    private String idSinistro;
    private Consulta consulta;
    private String causa;
    private double custo;

    public Sinistro(){
        this.idSinistro = UUID.randomUUID().toString();
    }

}

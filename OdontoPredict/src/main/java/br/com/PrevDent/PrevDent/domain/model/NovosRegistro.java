package br.com.PrevDent.PrevDent.domain.model;

import lombok.Data;

@Data
public class NovosRegistro {

    private String idRegistro;
    private String tipo;
    private String ocorrencia;
    private String intensidade;
    private String informacoesAdicionais;
}

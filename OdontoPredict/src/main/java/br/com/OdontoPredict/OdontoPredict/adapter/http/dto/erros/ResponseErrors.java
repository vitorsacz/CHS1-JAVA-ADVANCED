package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.erros;

import lombok.Data;

@Data
public class ResponseErrors {

    private String campo;
    private String mensagem;
}

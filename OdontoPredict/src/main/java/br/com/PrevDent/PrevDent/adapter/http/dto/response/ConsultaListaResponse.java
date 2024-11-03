package br.com.PrevDent.PrevDent.adapter.http.dto.response;

import br.com.PrevDent.PrevDent.adapter.http.dto.request.DentistaCreatRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.PacienteCreateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaListaResponse {

    @JsonProperty("id_consulta")
    private String idConsulta;

    @JsonProperty("paciente")
    @NotNull(message = "O paciente é obrigatório.")
    private PacienteCreateRequest paciente;

    @JsonProperty("dentista")
    @NotNull(message = "O dentista é obrigatório.")
    private DentistaCreatRequest dentista;

    @JsonProperty("data_consulta")
    @NotNull(message = "A data da consulta é obrigatória.")
    private Date data;

}
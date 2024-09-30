package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDto {

    @JsonProperty("id_consulta")
    private String idConsulta;

    @JsonProperty("paciente")
    @NotNull(message = "O paciente é obrigatório.")
    private PacienteDto paciente;

    @JsonProperty("dentista")
    @NotNull(message = "O dentista é obrigatório.")
    private DentistaDto dentista;

    @JsonProperty("data_consulta")
    @NotNull(message = "A data da consulta é obrigatória.")
    private Date data;

    @JsonProperty("tipo_tratamento")
    @NotBlank(message = "O tipo de tratamento é obrigatório.")
    private String tipoTratamento;

    @JsonProperty("diagnostico")
    private DiagnosticoDto diagnostico;
}

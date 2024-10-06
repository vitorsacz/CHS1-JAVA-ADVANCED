package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PacienteListaResponse {

    @JsonProperty("id_paciente")
    private String idPaciente;

    @JsonProperty("nome")
    @NotNull
    @NotEmpty
    private String nome;

    @JsonProperty("data_nascimento")
    @NotNull
    @NotEmpty
    private String dataNascimento;
}

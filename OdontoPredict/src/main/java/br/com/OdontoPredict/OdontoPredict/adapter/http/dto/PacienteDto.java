package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

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

package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    @JsonProperty("nome")
    @NotBlank
    private String nome;

    @JsonProperty("data_nascimento")
    @NotBlank
    private String dataNascimento;
}

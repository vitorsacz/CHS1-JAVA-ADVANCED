package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDto {

    @JsonProperty("data")
    @NonNull
    private Date data;
    @JsonProperty("tipo_tratamento")
    @NotBlank
    private String tipoTratamento;
}

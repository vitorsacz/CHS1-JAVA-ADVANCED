package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinistroDto {

    @JsonProperty("id_sinistro")
    private Long idSinistro;

    @JsonProperty("consulta")
    @NotNull(message = "A consulta é obrigatória.")
    private ConsultaDto consulta;

    @JsonProperty("causa")
    @NotBlank(message = "A causa do sinistro é obrigatória.")
    private String causa;

    @JsonProperty("custo")
    @Positive(message = "O custo deve ser um valor positivo.")
    private double custo;
}

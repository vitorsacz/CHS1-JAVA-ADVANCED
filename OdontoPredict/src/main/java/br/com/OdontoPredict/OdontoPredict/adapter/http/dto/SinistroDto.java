package br.com.OdontoPredict.OdontoPredict.adapter.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinistroDto {

    @JsonProperty("causa")
    @NotBlank
    private String causa;

    @JsonProperty("custo")
    @NonNull
    private double custo;
}

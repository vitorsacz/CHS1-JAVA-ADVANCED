package br.com.OdontoPredict.OdontoPredict.adapter.http.request;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.ConsultaDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistaCreatRequest {

    @JsonProperty("id_dentista")
    private String idDentista;

    @JsonProperty("nome_dentista")
    @NotBlank(message = "O nome do dentista é obrigatório.")
    private String nome;

    @JsonProperty("especializacao")
    @NotBlank(message = "A especialização do dentista é obrigatória.")
    private String especializacao;

    @JsonProperty("consultas")
    private List<ConsultaDto> consultas;

}

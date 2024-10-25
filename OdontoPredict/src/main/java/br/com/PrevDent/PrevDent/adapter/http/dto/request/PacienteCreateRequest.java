package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteCreateRequest {

    @JsonProperty("id_paciente")
    private String idPaciente;

    @JsonProperty("nome")
    @NotNull
    @NotEmpty
    private String nome;

    @JsonProperty("cpf")
    @NotNull
    @NotEmpty
    private String cpf;


    @JsonProperty("data_nascimento")
    @NotNull
    @NotEmpty
    private String dataNascimento;

    @JsonProperty("consultas")
    private List<ConsultaCreatRequest> consultas;
}

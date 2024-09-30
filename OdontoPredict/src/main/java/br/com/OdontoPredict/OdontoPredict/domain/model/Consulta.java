package br.com.OdontoPredict.OdontoPredict.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {

    private String idConsulta;
    private Paciente paciente;
    private Dentista dentista;
    private Date data;
    private String tipoTratamento;
    private Diagnostico diagnostico;
}

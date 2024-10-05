package br.com.OdontoPredict.OdontoPredict.domain.model;


import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class Consulta {

    private String idConsulta;
    private Paciente paciente;
    private Dentista dentista;
    private Date data;
    private String tipoTratamento;
    private Diagnostico diagnostico;

    public Consulta() {
        this.idConsulta = UUID.randomUUID().toString();
    }
}

package br.com.OdontoPredict.OdontoPredict.adapter.http.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "consulta")
@Table(name = "tbl_consulta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Consulta {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String idConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    private Date data;
    private String tipoTratamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnostico_id", referencedColumnName = "idConsulta")
    private Diagnostico diagnostico; // Relacionamento com Diagnostico

}
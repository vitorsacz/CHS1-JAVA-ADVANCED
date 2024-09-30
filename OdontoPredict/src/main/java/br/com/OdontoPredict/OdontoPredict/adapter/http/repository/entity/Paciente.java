package br.com.OdontoPredict.OdontoPredict.adapter.http.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "paciente")
@Table(name = "tbl_paciente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idPaciente;

    private String nome;
    private String especializacao;

    @OneToMany(mappedBy = "dentista")
    private List<Consulta> consultas;
}

package br.com.PrevDent.PrevDent.adapter.repository.entity;

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
public class PacienteEntity {

    @Id
    @Column(name = "id_paciente")
    private String idPaciente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false )
    private String cpf;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @OneToMany(mappedBy = "paciente")
    private List<ConsultaEntity> consultas;
}

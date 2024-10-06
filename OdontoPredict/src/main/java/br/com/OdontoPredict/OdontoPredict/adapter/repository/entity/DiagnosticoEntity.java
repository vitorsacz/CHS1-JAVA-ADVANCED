package br.com.OdontoPredict.OdontoPredict.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "diagnostico")
@Table(name = "tbl_diagnostico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosticoEntity {

    @Id
    @Column(name = "id_diagnostico")
    private String idDiagnostico;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "recomendacao")
    private String recomendacao;

    @OneToOne(mappedBy = "diagnostico")
    private ConsultaEntity consulta;
}

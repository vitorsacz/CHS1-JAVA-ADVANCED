package br.com.OdontoPredict.OdontoPredict.adapter.http.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "diagnostico")
@Table(name = "tbl_diagnostico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idDiagnostico;

    private String descricao;
    private String recomendacao;

    @OneToOne(mappedBy = "diagnostico")
    private Consulta consulta;
}

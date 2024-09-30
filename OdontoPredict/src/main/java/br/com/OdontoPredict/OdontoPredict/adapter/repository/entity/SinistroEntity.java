package br.com.OdontoPredict.OdontoPredict.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sinistro")
@Table(name = "tbl_sinistro")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SinistroEntity {

    @Id
    @Column(name = "id_sinistro")
    private Long idSinistro;

    @ManyToOne
    @JoinColumn(name = "id_consulta")
    private ConsultaEntity consulta;

    @Column(name = "causa")
    private String causa;

    @Column(name = "custo")
    private double custo;
}

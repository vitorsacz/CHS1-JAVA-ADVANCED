package br.com.OdontoPredict.OdontoPredict.adapter.http.repository.entity;

import jakarta.persistence.*;

@Entity(name = "sinistro")
@Table(name = "tbl_sinistro")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long idSinistro;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;  // Relacionamento com Consulta

    private String causa;
    private double custo;
}

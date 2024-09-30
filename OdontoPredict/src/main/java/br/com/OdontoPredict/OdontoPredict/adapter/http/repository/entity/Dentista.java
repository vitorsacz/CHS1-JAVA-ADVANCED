package br.com.OdontoPredict.OdontoPredict.adapter.http.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity(name = "dentista")
@Table(name = "tbl_Dentista")
@Data
@AllArgsConstructor
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID.)
    private String idDentista;

    private String nome;
    private String especializacao;

    @OneToMany(mappedBy = "dentista")
    private List<Consulta> consultas;
}

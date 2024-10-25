package br.com.OdontoPredict.OdontoPredict.domain.ports.out;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaPortOut extends JpaRepository<ConsultaEntity, String> {
}

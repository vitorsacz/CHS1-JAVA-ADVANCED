package br.com.OdontoPredict.OdontoPredict.domain.ports.out;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientePortOut extends JpaRepository<PacienteEntity, String> {
}

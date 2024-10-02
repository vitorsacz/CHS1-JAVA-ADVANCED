package br.com.OdontoPredict.OdontoPredict.domain.ports.out;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaPortOut extends JpaRepository<DentistaEntity, String> {
}

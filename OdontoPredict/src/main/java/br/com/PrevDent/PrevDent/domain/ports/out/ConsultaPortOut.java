package br.com.PrevDent.PrevDent.domain.ports.out;

import br.com.PrevDent.PrevDent.adapter.repository.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaPortOut extends JpaRepository<ConsultaEntity, String> {
}

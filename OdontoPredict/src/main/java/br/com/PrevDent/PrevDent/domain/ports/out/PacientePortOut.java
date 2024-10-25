package br.com.PrevDent.PrevDent.domain.ports.out;

import br.com.PrevDent.PrevDent.adapter.repository.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientePortOut extends JpaRepository<PacienteEntity, String> {

    public PacienteEntity findByCpf(String cpf);
}

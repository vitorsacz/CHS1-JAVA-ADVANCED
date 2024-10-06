package br.com.OdontoPredict.OdontoPredict.domain.ports.out;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.DiagnosticoEntity;
import br.com.OdontoPredict.OdontoPredict.domain.model.Dentista;
import br.com.OdontoPredict.OdontoPredict.domain.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoPortOut extends JpaRepository<DiagnosticoEntity, String> {

    public DiagnosticoEntity findByIdDiagnostico(String idDiagnostico);
}

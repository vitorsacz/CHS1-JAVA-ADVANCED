package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.PacienteDto;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteDtoMapper {

    public Paciente converter(PacienteDto pacienteDto) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteDto.getNome());
        paciente.setDataNascimento(pacienteDto.getDataNascimento());
        return paciente;
    }
}

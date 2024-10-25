package br.com.PrevDent.PrevDent.adapter.http.dto.mapper;

import br.com.PrevDent.PrevDent.adapter.http.dto.request.PacienteCreateRequest;
import br.com.PrevDent.PrevDent.adapter.http.dto.request.PacienteUpdateRequest;
import br.com.PrevDent.PrevDent.domain.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteDtoMapper {

    public Paciente converterPacienteDto(PacienteCreateRequest pacienteCreateRequest) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteCreateRequest.getNome());
        paciente.setCpf(pacienteCreateRequest.getCpf());
        paciente.setDataNascimento(pacienteCreateRequest.getDataNascimento());
        return paciente;
    }


    public Paciente converterPacienUpdateteDto(PacienteUpdateRequest pacienteUpdateDtoDto) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteUpdateDtoDto.getNome());
        return paciente;
    }


}

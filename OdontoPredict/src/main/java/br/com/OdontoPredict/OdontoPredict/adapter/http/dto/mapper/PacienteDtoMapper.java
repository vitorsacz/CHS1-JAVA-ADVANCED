package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.http.request.PacienteCreateRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.request.PacienteUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.response.PacienteListaResponse;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
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

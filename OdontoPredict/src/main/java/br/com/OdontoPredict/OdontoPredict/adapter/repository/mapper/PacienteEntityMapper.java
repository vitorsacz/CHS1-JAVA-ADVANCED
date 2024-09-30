package br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.PacienteEntity;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteEntityMapper {

    public Paciente converterPaciente(PacienteEntity pacienteEntity){
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteEntity.getNome());
        paciente.setDataNascimento(pacienteEntity.getDataNascimento());
        paciente.setIdPaciente(pacienteEntity.getIdPaciente());
        return paciente;
    }

    public void atualizarPacienteEntity(PacienteEntity pacienteEntity, Paciente paciente){
        paciente.setNome(pacienteEntity.getNome());
        paciente.setDataNascimento(pacienteEntity.getDataNascimento());

    }
}

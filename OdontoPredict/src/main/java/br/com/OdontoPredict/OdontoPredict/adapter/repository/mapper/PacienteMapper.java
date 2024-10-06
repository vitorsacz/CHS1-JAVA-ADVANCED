package br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.PacienteEntity;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente converterPaciente(PacienteEntity pacienteEntity){
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteEntity.getNome());
        paciente.setCpf(pacienteEntity.getCpf());
        paciente.setDataNascimento(pacienteEntity.getDataNascimento());
        paciente.setIdPaciente(pacienteEntity.getIdPaciente());
        return paciente;
    }

    public PacienteEntity converterPacienteEntity(Paciente paciente){
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNome(paciente.getNome());
        pacienteEntity.setCpf(paciente.getCpf());
        pacienteEntity.setDataNascimento(paciente.getDataNascimento());
        pacienteEntity.setIdPaciente(paciente.getIdPaciente());
        return pacienteEntity;
    }

    public Paciente converterAtualizacaoDoPaciente(PacienteEntity pacienteEntity){
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteEntity.getNome());
        return paciente;
    }

    public void atualizarPacienteEntity(PacienteEntity pacienteEntity, Paciente paciente){
        pacienteEntity.setNome(paciente.getNome());
    }
}

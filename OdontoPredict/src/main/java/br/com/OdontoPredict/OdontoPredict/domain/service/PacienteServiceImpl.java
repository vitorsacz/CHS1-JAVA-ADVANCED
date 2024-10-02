package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.PacienteEntity;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper.PacienteMapper;
import br.com.OdontoPredict.OdontoPredict.domain.exception.PacienteNotFoundException;
import br.com.OdontoPredict.OdontoPredict.domain.model.Paciente;
import br.com.OdontoPredict.OdontoPredict.domain.ports.out.PacientePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacientePortOut pacientePortOut;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public void cadastarPaciente(Paciente paciente) {
        PacienteEntity pacienteEntity = pacienteMapper.converterPacienteEntity(paciente);
        pacientePortOut.save(pacienteEntity);
    }

    @Override
    public List<Paciente> listarPacientes() {
        List<PacienteEntity> pacienteExistente = pacientePortOut.findAll();

        List<Paciente> pacientes = new ArrayList<>();

        for (PacienteEntity pacienteEntity : pacienteExistente) {

            Paciente paciente = pacienteMapper.converterPaciente(pacienteEntity);

            pacientes.add(paciente);
        }

        return pacientes;
    }


    @Override
    public Optional<Paciente> atualizarPaciente(String id, Paciente paciente) {

        Optional<PacienteEntity> pacienteExistente = pacientePortOut.findById(id);

        if (pacienteExistente.isPresent()) {

            PacienteEntity autualizar = pacienteExistente.get();
            pacienteMapper.atualizarPacienteEntity(autualizar, paciente);

            PacienteEntity pacienteAtualizada = pacientePortOut.save(autualizar);
            Paciente pacienteAtualizado = pacienteMapper.converterAtualizacaoDoPaciente(pacienteAtualizada);

            return Optional.of(pacienteAtualizado);

        } else {
            return Optional.empty();
        }

    }

    @Override
    public boolean excluirPaciente(String id) {

        Optional<PacienteEntity> pacienteExistente = pacientePortOut.findById(id);

        if (pacienteExistente.isPresent()) {

            pacientePortOut.deleteById(id);

            return true;

        } else {
            return false;
        }
    }

    @Override
    public Paciente buscarPaciente(String id) {
        Optional<PacienteEntity> pacienteDetalhado = pacientePortOut.findById(id);

        if(pacienteDetalhado.isPresent()){

            Paciente paciente = pacienteMapper.converterPaciente(pacienteDetalhado.get());

            return paciente;

        } else {
            throw new PacienteNotFoundException();
        }
    }
}

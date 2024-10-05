package br.com.OdontoPredict.OdontoPredict.domain.service;

import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.ConsultaEntity;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.DentistaEntity;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.entity.PacienteEntity;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper.ConsultaMapper;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper.DentistaMapper;
import br.com.OdontoPredict.OdontoPredict.adapter.repository.mapper.PacienteMapper;
import br.com.OdontoPredict.OdontoPredict.domain.exception.ConsultaNotFoudException;
import br.com.OdontoPredict.OdontoPredict.domain.model.Consulta;
import br.com.OdontoPredict.OdontoPredict.domain.ports.out.ConsultaPortOut;
import br.com.OdontoPredict.OdontoPredict.domain.ports.out.DentistaPortOut;
import br.com.OdontoPredict.OdontoPredict.domain.ports.out.PacientePortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaPortOut consultaPortOut;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private DentistaMapper dentistaMapper;

    @Autowired
    private PacientePortOut pacientePortOut;

    @Autowired
    private DentistaPortOut dentistaPortOut;

    @Override
    public void cadastrarConsulta(Consulta consulta) {

        PacienteEntity paciente = pacientePortOut.findByCpf(consulta.getPaciente().getCpf());
        consulta.setPaciente(pacienteMapper.converterPaciente(paciente));

        DentistaEntity dentista = dentistaPortOut.findByDocumento(consulta.getDentista().getDocumento());
        consulta.setDentista(dentistaMapper.converteDentista(dentista));

        ConsultaEntity consultaEntity = consultaMapper.converteConsultaEntity(consulta);

        consultaPortOut.save(consultaEntity);
    }

    @Override
    public List<Consulta> listarConsultas() {

        List<ConsultaEntity> consultasExistentes = consultaPortOut.findAll();

        List<Consulta> consultas = new ArrayList<>();

        for (ConsultaEntity consultaEntity : consultasExistentes) {

            Consulta consulta = consultaMapper.converteConsulta(consultaEntity);

            consultas.add(consulta);
        }

        return consultas;
    }

    @Override
    public Optional<Consulta> atualizarConsulta(String id, Consulta consulta) {
        Optional<ConsultaEntity> consultaExistente = consultaPortOut.findById(id);

        if (consultaExistente.isPresent()) {

            ConsultaEntity consultaParaAtualizar = consultaExistente.get();
            consultaMapper.atualizarConsultaEntity(consultaParaAtualizar, consulta);

            ConsultaEntity consultaAtualizada = consultaPortOut.save(consultaParaAtualizar);
            Consulta consultaAtualizadaDto = consultaMapper.converterAtualizacaoDaConsulta(consultaAtualizada);

            return Optional.of(consultaAtualizadaDto);

        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean excluirConsulta(String id) {
        Optional<ConsultaEntity> consultaExistente = consultaPortOut.findById(id);

        if (consultaExistente.isPresent()) {

            consultaPortOut.deleteById(id);

            return true;

        } else {
            return false;
        }
    }

    @Override
    public Consulta buscarConsulta(String id) {
        Optional<ConsultaEntity> consultaDetalhada = consultaPortOut.findById(id);

        if(consultaDetalhada.isPresent()){

            Consulta consulta = consultaMapper.converteConsulta(consultaDetalhada.get());

            return consulta;

        } else {
            throw new ConsultaNotFoudException();
        }
    }

}

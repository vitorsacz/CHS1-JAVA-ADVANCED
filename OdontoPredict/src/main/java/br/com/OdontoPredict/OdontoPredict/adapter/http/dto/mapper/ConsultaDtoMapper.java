package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper;


import br.com.OdontoPredict.OdontoPredict.adapter.http.request.ConsultaCreatRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.request.ConsultaUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.domain.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaDtoMapper {

    @Autowired
    private PacienteDtoMapper pacienteDtoMapper;

    @Autowired
    private DentistaDtoMapper dentistaDtoMapper;

    public Consulta criandoDtoParaConsulta(ConsultaCreatRequest consultaCreatRequest) {
        Consulta consulta = new Consulta();
        consulta.setData(consultaCreatRequest.getData());
        consulta.setTipoTratamento(consultaCreatRequest.getTipoTratamento());

        consulta.setPaciente(pacienteDtoMapper.converterPacienteDto(consultaCreatRequest.getPaciente()));
        consulta.setDentista(dentistaDtoMapper.createDentista(consultaCreatRequest.getDentista()));
        return consulta;
    }

    public Consulta converterConsultaUpdateteDto(ConsultaUpdateRequest consultaUpdateRequest) {
        Consulta consulta = new Consulta();
        consulta.setData(consultaUpdateRequest.getData());
        consulta.setData(consultaUpdateRequest.getData());
        return consulta;
    }
}

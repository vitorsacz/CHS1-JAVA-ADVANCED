package br.com.OdontoPredict.OdontoPredict.adapter.http.dto.mapper;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.request.DentistaCreatRequest;
import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.request.DentistaUpdateRequest;
import br.com.OdontoPredict.OdontoPredict.domain.model.Dentista;
import org.springframework.stereotype.Component;

@Component
public class DentistaDtoMapper {

    public Dentista createDentista(DentistaCreatRequest dentistaCreatRequest) {
        Dentista dentista = new Dentista();
        dentista.setNome(dentistaCreatRequest.getNome());
        dentista.setDocumento(dentistaCreatRequest.getDocumento());
        dentista.setEspecializacao(dentistaCreatRequest.getEspecializacao());
        return dentista;
    }

    public Dentista converterDentistaUpdateteDto(DentistaUpdateRequest dentistaUpdateDtoDto) {
        Dentista dentista = new Dentista();
        dentista.setNome(dentistaUpdateDtoDto.getNome());
        dentista.setEspecializacao(dentistaUpdateDtoDto.getEspecializacao());
        return dentista;
    }

}

package br.com.OdontoPredict.OdontoPredict.adapter.http.exception;

import br.com.OdontoPredict.OdontoPredict.adapter.http.dto.erros.ResponseErrors;
import br.com.OdontoPredict.OdontoPredict.domain.exception.ConsultaNotFoudException;
import br.com.OdontoPredict.OdontoPredict.domain.exception.DentistaNotFoudException;
import br.com.OdontoPredict.OdontoPredict.domain.exception.PacienteNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> tratarErrosDeValidacaoFisica(MethodArgumentNotValidException exception){

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        List<ResponseErrors> listaDeErro = new ArrayList<>();

        for (FieldError fieldError : fieldErrors){

            String campo = fieldError.getField();
            String mensagemDeErro = fieldError.getDefaultMessage();

            ResponseErrors responseErro = new ResponseErrors();
            responseErro.setCampo(campo);
            responseErro.setMensagem(mensagemDeErro);

            listaDeErro.add(responseErro);

        }

        return ResponseEntity.badRequest().body(listaDeErro);
    }

    @ExceptionHandler(PacienteNotFoundException.class)
    public ResponseEntity<Object> tratarPacienteNotFoundException(PacienteNotFoundException pacienteNotFoundException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(pacienteNotFoundException.getMessage());
        return ResponseEntity.status(pacienteNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(DentistaNotFoudException.class)
    public ResponseEntity<Object> tratarDentistaNotFoundException(DentistaNotFoudException dentistaNotFoudException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(dentistaNotFoudException.getMessage());
        return ResponseEntity.status(dentistaNotFoudException.HTTP_STATUS_CODE).body(responseErro);
    }

    @ExceptionHandler(ConsultaNotFoudException.class)
    public  ResponseEntity<Object> tratarConsultaNotFoundException(ConsultaNotFoudException consultaNotFoudException){
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(consultaNotFoudException.getMessage());
        return ResponseEntity.status(consultaNotFoudException.HTTP_STATUS_CODE).body(responseErro);
    }
}

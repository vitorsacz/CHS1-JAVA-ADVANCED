package br.com.PrevDent.PrevDent.usecasee.ports.in;

public interface NovosRegistroPortIn<Entrada, Saida> {

    Saida cadastrarRegistro(Entrada entrada);

    Saida listarRegistros();

    Saida atualizarRegistro(String id, Entrada obj);

    Saida deletarRegistro(String id);

    Saida detalharRegistro(String id);
}

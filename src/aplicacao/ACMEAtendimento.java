package aplicacao;

import dados.Atendimento.Atendimento;

import java.util.ArrayList;

public class ACMEAtendimento {
    private ArrayList<Atendimento> atendimentos;

    public ACMEAtendimento() {
        atendimentos = new ArrayList<>();
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }
}

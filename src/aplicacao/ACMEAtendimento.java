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

    public boolean cadastraAtendimento(Atendimento atendimento) {
        for (Atendimento a: atendimentos) {
            if (a.getCod() == atendimento.getCod()) {
                return false;
            }
        }
        atendimentos.add(atendimento);
        return true;
    }

}

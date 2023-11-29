package aplicacao;

import dados.Atendimento.Atendimento;

import java.util.ArrayList;

public class ACMEAtendimento {
    private ArrayList<Atendimento> atendimentos;

    public ACMEAtendimento() {
        atendimentos = new ArrayList<>();

        //atendimento de teste
        cadastraAtendimento(new Atendimento(1, "01/01/2020", 1, null, null, null));
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

package aplicacao;

import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;
import dados.Equipe.Equipe;

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

    public boolean alocaEquipe(ArrayList<Equipe> equipes) {
        for (Atendimento a : atendimentos) {
            for (Equipe e : equipes) {
                if (! e.getEstaAlocada()) {
                    e.setAtendimento(a);
                    if (a.getStatus() == AtendimentoStatus.PEN && e.getDistancia() < 5000) {
                        a.setEquipe(e);
                        e.setEstaAlocada(true);
                        a.setStatus(AtendimentoStatus.EX);

                    }
                }
                e.setAtendimento(null);
            }
            if (a.getEquipe().getEstaAlocada()) {
                a.setStatus(AtendimentoStatus.CANCEL);
                return false;
            }
        }
        return true;
    }
}

package aplicacao;

import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

import java.util.ArrayList;

public class ACMEAtendimento {
    private ArrayList<Atendimento> atendimentos;

    public ACMEAtendimento() {
        atendimentos = new ArrayList<>();
        atendimentos.add(new Atendimento(1, "01/01/2020", 2, null, null, AtendimentoStatus.CANCEL));

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
        alocaEquipe(null);
        return true;
    }

    public void alocaEquipe(ArrayList<Equipe> equipes) {
        ArrayList<Equipe> equipesDisponiveis = new ArrayList<>();
        Equipe equipeDisponivel = null;
        boolean estaDisponivel = true;

        for (Atendimento a : atendimentos) {
            for (Equipe e : equipes) {
                if (a.getEquipe() == e) {
                    estaDisponivel = false;
                    equipeDisponivel = e;
                }
            }
            if (estaDisponivel) {
                equipesDisponiveis.add(equipeDisponivel);
            }
            estaDisponivel = true;
        }

        for (Atendimento a : atendimentos) {
            for (Equipe e : equipesDisponiveis) {
                if (a.getStatus() == AtendimentoStatus.PEN && e.getDistancia() < 5000) {
                    a.setEquipe(e);
                    a.setStatus(AtendimentoStatus.EX);
                }
            }
            if (a.getStatus() == AtendimentoStatus.PEN) {
                a.setStatus(AtendimentoStatus.CANCEL);
            }
        }
    }
}

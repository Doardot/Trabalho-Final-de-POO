package aplicacao;

import dados.Atendimento;
import dados.Equipe;
import dados.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ACMERescue {
    private ArrayList<Evento> eventos;
    private ArrayList<Equipe> equipes;
    private ArrayList<Atendimento> atendimentos;


    public ACMERescue() {
        eventos = new ArrayList<>();
        equipes = new ArrayList<>();
        atendimentos = new ArrayList<>();
    }
    public void executa(){

    }

    public boolean cadastraEvento(Evento evento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getCodigo() .equals(evento.getCodigo())) {
                return false;
            }
        }
        eventos.add(evento);
        ordena();
        return true;
    }

    public void cadastraEquipe (Equipe equipe) {
    }

    public void cadastraEquipamento (Equipamento equipamento) {
    }

    public void cadastraAtendimento () {
    }

    public void mostraRelatorioGeral () {
    }

    public void vincularEquipamentoEquipe () {
    }

    public void alocarAtendimento () {
    }

    public void consultarTodosAtendimentos () {
    }

    public void alterarSituacaoAtendimento () {
    }

    public void carregarDadosIniciais () {
    }

    public void salvarDados () {
    }

    public void carregarDados() {

    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    private void ordena() {
        eventos.sort(Comparator.comparing(Evento::getCodigo));
        equipes.sort(Comparator.comparing(Equipe::getCodinome));
    }

    public void finalizarSistema() {
        System.exit(0);
    }
}

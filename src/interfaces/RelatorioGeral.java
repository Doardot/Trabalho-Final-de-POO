package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RelatorioGeral extends JFrame implements ActionListener {

    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private ACMEEquipamento equipamento;
    private JLabel relatorioGeralTitulo;
    private JTextPane textPane1;
    private JPanel janela;
    private JButton fecharBotao;

    public RelatorioGeral(ACMEEquipe equipe, ACMEEvento evento, ACMEAtendimento atendimento, ACMEEquipamento equipamento) {
        this.equipe = equipe;
        this.evento = evento;
        this.atendimento = atendimento;
        this.equipamento = equipamento;
        setContentPane(janela);
        textPane1.setOpaque(false);
        mostrarRelatorio();
        this.setSize(800, 700);
        this.setVisible(true);
        fecharBotao.addActionListener(this);

        this.setLocationRelativeTo(null);
    }

    public void mostrarRelatorio() {
        ArrayList<Atendimento> listaAtendimento;
        listaAtendimento = atendimento.getAtendimentos();
        String texto = "";
        boolean vazio = true;
        if (!listaAtendimento.isEmpty()) {
            texto += "\nAtendimentos:\n";
            vazio = false;
            for (Atendimento a : listaAtendimento) {
                texto += a.toString() + "\n";
            }
        }

        ArrayList<Evento> listaEvento;
        listaEvento = evento.getEventos();
        if (!listaEvento.isEmpty()) {
            texto += "\nEventos:\n";
            vazio = false;
            for (Evento evento : listaEvento) {
                texto += evento.toString() + "\n";
            }
        }

        ArrayList<Equipe> listaEquipe;
        listaEquipe = equipe.getEquipes();
        if (!listaEquipe.isEmpty()) {
            texto += "\nEquipes: \n";
            vazio = false;
            for (Equipe equipe : listaEquipe) {
                texto += equipe.toString();
            }
        }

        ArrayList<Equipamento> listaEquipamento;
        listaEquipamento = equipamento.getLista();

        if (!listaEquipamento.isEmpty()) {
            texto += "\nEquipamentos: \n";
            vazio = false;
            for (Equipamento equipamento : listaEquipamento) {
                texto += equipamento.toString();
            }
        }
        if (!vazio) {
            textPane1.setText(texto);
        } else {
            new JanelaDeErro("Erro: Não há nenhum dado cadastrado");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fecharBotao) {
            this.dispose();
        }
    }
}

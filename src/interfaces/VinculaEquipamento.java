package interfaces;

import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VinculaEquipamento extends JFrame implements ActionListener {

    private JLabel titulo;
    private JPanel painel;
    private JLabel labelEquipa;
    private JTextField insereEquipamento;
    private JLabel labelEquipe;
    private JTextField insereEquipe;
    private JTextArea textoVinc;
    private JButton confirmaButton;
    private JButton botaoFecha;

    private ACMEEquipe acmeEquipe;
    private Equipe equipe;
    private ACMEEquipamento acmeEquipamento;
    private Equipamento equipamento;


    public VinculaEquipamento(ACMEEquipe equipe, ACMEEquipamento equipamento) {
        this.add(painel);
        this.acmeEquipe = equipe;
        this.acmeEquipamento = equipamento;

        this.setSize(800, 400);
        this.dispose();
        this.setVisible(true);

        this.add(painel);
        painel.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        confirmaButton.addActionListener(this);
        botaoFecha.addActionListener(this);

        mostrarEquipamentoEEquipe();
    }

    public JPanel getPainel() {
        return painel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == confirmaButton) {
            String equipamentoSelecionado = insereEquipamento.getText();
            String equipeSelecionada = insereEquipe.getText();

            Equipamento equipamentoIN = null;
            for (Equipamento eq : acmeEquipamento.getLista()) {
                if (eq.getNome().equalsIgnoreCase(equipamentoSelecionado)) {
                    equipamentoIN = eq;
                    break;
                }
            }

            Equipe equipeIN = null;
            for (Equipe eq : acmeEquipe.getEquipes()) {
                if (eq.getCodinome().equalsIgnoreCase(equipeSelecionada)) {
                    equipeIN = eq;
                    break;
                }
            }

            if (equipamentoIN != null && equipeIN != null) {
                if(equipeIN.getEquipamento() != null) {
                    new JanelaDeErro("Equipe já possui equipamento");
                    return;
                }
                equipeIN.setEquipamento(equipamentoIN);
                textoVinc.append("Equipamento: " + equipamentoSelecionado + ", Vinculado à equipe: " + equipeSelecionada + "\n");
                textoVinc.append("Codinome: " + equipeIN.getCodinome()  + ", Equipamento:" + equipeIN.getEquipamento() + "\n") ;

            } else {
                new JanelaDeErro("Equipamento ou equipe não encontrados\n");
            }
        }

        if (e.getSource() == botaoFecha) {
            this.dispose();
        }
    }

    public void mostrarEquipamentoEEquipe() {
        ArrayList<Equipamento> equipamentos1;
        equipamentos1 = acmeEquipamento.getLista();
        String texto = "";
        boolean vazio = true;

        if (!equipamentos1.isEmpty()) {
            texto += "\nEquipamentos:\n";
            vazio = false;
            for (Equipamento eq : equipamentos1) {
                texto += eq.toString();
            }
        }

        ArrayList<Equipe> listaEquipe;
        listaEquipe = acmeEquipe.getEquipes();
        if (!listaEquipe.isEmpty()) {
            texto += "\nEquipes:\n";
            vazio = false;
            for (Equipe equipe : listaEquipe) {
                texto += equipe.toString();
            }
        }

        if (!vazio) {
            textoVinc.setText(texto);
        } else {
            new JanelaDeErro("Erro: Não há nenhum dado cadastrado");
        }
    }
}


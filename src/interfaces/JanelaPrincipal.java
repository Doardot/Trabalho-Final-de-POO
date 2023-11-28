package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
//import dados.Equipamento.Equipamento;
import dados.Equipamento.*;
import dados.Equipe.Equipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private ACMEEquipe ACMEequipe;
    private ACMEEvento ACMEevento;
    private ACMEAtendimento ACMEatendimento;
    private ACMEEquipamento ACMEequipamento;
    private Equipamento equipamento;
    private Equipe equipe;
    private JButton equipamentoBotao;
    private JButton fecharBotao;
    private JButton equipeBotao;
    private JButton eventoBotao;
    private JButton atendimentoBotao;
    private JPanel JanelaPrincipal;
    private JLabel tituloTrab;
    private JButton vincularEquip;
    private JTextField insereEquipe;
    private JTextField insereEquipamento;
    private JButton botaoConfirma;
    private JTextArea textoVinc;

    public JanelaPrincipal() {
        ACMEequipe = new ACMEEquipe();
        ACMEevento = new ACMEEvento();
        ACMEatendimento = new ACMEAtendimento();
        ACMEequipamento = new ACMEEquipamento();

        this.setVisible(true);
        this.add(JanelaPrincipal);
        this.setSize(700,600);
        atendimentoBotao.addActionListener(this);
        eventoBotao.addActionListener(this);
        equipeBotao.addActionListener(this);
        equipamentoBotao.addActionListener(this);
        fecharBotao.addActionListener(this);

        vincularEquip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipamentoSelecionado = insereEquipamento.getText();
                String equipeSelecionada = insereEquipe.getText();

                Equipamento equipamentoIN = null;
                for (Equipamento eq : ACMEequipamento.getLista()) {
                    if (eq.getNome().equals(equipamentoSelecionado)) {
                        equipamentoIN = eq;
                        break;
                    }
                }

                Equipe equipeIN = null;
                for (Equipe eq : ACMEequipe.getEquipes()) {
                    if (eq.getCodinome().equals(equipeSelecionada)) {
                        equipeIN = eq;
                        break;
                    }
                }

                if (equipamentoIN != null && equipeIN != null) {
                    equipeIN.setEquipamento(equipamentoIN);
                    textoVinc.append("Equipamento " + equipamentoSelecionado + " vinculado à equipe " + equipeSelecionada + "\n");
                } else {
                    textoVinc.append("Equipamento ou equipe não encontrados\n");
                }
            }
    });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atendimentoBotao) {
            // adicionar formulario de atendimento
        }
        if(e.getSource() == eventoBotao) {
            FormularioEvento formEvento = new FormularioEvento(ACMEevento);
        }
        if(e.getSource() == equipeBotao) {
            FormularioEquipe formEquipe = new FormularioEquipe(ACMEequipe);
        }
        if(e.getSource() == equipamentoBotao) {
            FormularioEquipamento formEquipamento = new FormularioEquipamento(ACMEequipamento);
        }
        if(e.getSource() ==fecharBotao) {
            System.exit(0);
        }
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

}

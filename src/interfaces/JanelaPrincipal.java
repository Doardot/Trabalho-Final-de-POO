package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private ACMEEquipamento equipamento;
    private JButton equipamentoBotao;
    private JButton fecharBotao;
    private JButton equipeBotao;
    private JButton eventoBotao;
    private JButton atendimentoBotao;
    private JPanel JanelaPrincipal;
    private JLabel tituloTrab;
    private JButton relatorioGeral;
    private JButton vinculaEquipamento;

    public JanelaPrincipal() {
        equipe = new ACMEEquipe();
        evento = new ACMEEvento();
        atendimento = new ACMEAtendimento();
        equipamento = new ACMEEquipamento();

        this.setVisible(true);
        this.add(JanelaPrincipal);
        this.setSize(700,600);
        atendimentoBotao.addActionListener(this);
        eventoBotao.addActionListener(this);
        equipeBotao.addActionListener(this);
        equipamentoBotao.addActionListener(this);
        relatorioGeral.addActionListener(this);
        vinculaEquipamento.addActionListener(this);
        fecharBotao.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atendimentoBotao) {
            FormularioAtendimento formAtendimento = new FormularioAtendimento(atendimento, equipe, evento);
        }
        if(e.getSource() == eventoBotao) {
            FormularioEvento formEvento = new FormularioEvento(evento);
        }
        if(e.getSource() == equipeBotao) {
            FormularioEquipe formEquipe = new FormularioEquipe(equipe);
        }
        if(e.getSource() == equipamentoBotao) {
            FormularioEquipamento formEquipamento = new FormularioEquipamento(equipamento);
        }
        if(e.getSource()== vinculaEquipamento) {
            VinculaEquipamento vinculaEquipamento1 = new VinculaEquipamento(equipe, equipamento);
        }
        if(e.getSource() == relatorioGeral) {
            RelatorioGeral relatorioGeral1 = new RelatorioGeral(equipe, evento, atendimento, equipamento);
        }
        if(e.getSource() == fecharBotao) {
            System.exit(0);
        }
    }
    public void cadastraAtendimento () {
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

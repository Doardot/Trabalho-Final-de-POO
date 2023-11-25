package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal {
    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private JButton equipamentoBotao;
    private JButton fecharBotao;
    private JButton equipeBotao;
    private JButton eventoBotao;
    private JButton atendimentoBotao;
    private JPanel JanelaPrincipal;
    private JLabel tituloTrab;

    public JanelaPrincipal() {
        atendimentoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eventoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        equipeBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        equipamentoBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        fecharBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

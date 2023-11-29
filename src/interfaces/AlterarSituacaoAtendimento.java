package interfaces;

import aplicacao.ACMEAtendimento;
import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class AlterarSituacaoAtendimento extends JFrame implements ActionListener {

    private ACMEAtendimento acmeAtendimento;
    private Atendimento atendimento;
    private JPanel painel;
    private JLabel alteraSitu;
    private JButton fecharBotao;
    private JTextField tituloAtend;

    private JTextPane textoArea;
    private JLabel atendTitulo;
    private JTextField insereAtend;
    private JButton botaoConfirma;
    private JTextField insereAtendNovo;
    private JLabel atendNovoTitulo;
    private JButton mostrarAtend;
    private JComboBox boxSitu;

    public AlterarSituacaoAtendimento(ACMEAtendimento atendimento) {
        this.acmeAtendimento = atendimento;

        this.add(painel);
        this.setSize(800, 400);
        this.dispose();
        this.setVisible(true);

        painel.setVisible(true);
        atendTitulo.setVisible(true);
        insereAtend.setVisible(true);
        botaoConfirma.setVisible(true);
        textoArea.setVisible(true);
        alteraSitu.setVisible(true);
        fecharBotao.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        insereAtend.addActionListener(this);
        fecharBotao.addActionListener(this);
        botaoConfirma.addActionListener(this);
        mostrarAtend.addActionListener(this);

    }

    public JPanel getPainel() { return painel; }


    public void actionPerformed(ActionEvent e){

        if(e.getSource() == mostrarAtend) {
            mostrarAtendimento();
        }

        if(e.getSource() == botaoConfirma) {
            String texto = "";
            String at = insereAtend.getText();

                if(!at.isBlank()){
                for (Atendimento a : acmeAtendimento.getAtendimentos()) {
                    if (a.getCod() == Integer.parseInt(at)){
                        texto += "Atendimento: " + a;
                        if(a.getStatus().equals(AtendimentoStatus.FIN)) {
                            new JanelaDeErro("Erro: Atendimento já finalizado");
                            break;
                        }
                        if (Objects.equals(boxSitu.getSelectedItem(), "PEN")) {
                            a.setStatus(AtendimentoStatus.PEN);
                        }
                        if (boxSitu.getSelectedItem().equals("EX")) {
                            a.setStatus(AtendimentoStatus.EX);
                        }
                        if (boxSitu.getSelectedItem().equals("CANCEL")) {
                            a.setStatus(AtendimentoStatus.CANCEL);
                        }
                        if (boxSitu.getSelectedItem().equals("FIN")) {
                            a.setStatus(AtendimentoStatus.FIN);
                        }
                        texto += "\nNovo status: " + a.getStatus();
                    }
                }
            }

                if (!texto.isBlank()) {
                    textoArea.setText(texto);
                } else {
                    new JanelaDeErro("Erro: Atendimento não encontrado");
                }

        }

        if (e.getSource() == fecharBotao) {
            this.dispose();
        }

    }

    public void mostrarAtendimento() {
        ArrayList<Atendimento> listaAtendimento;
        listaAtendimento = acmeAtendimento.getAtendimentos();
        String texto = "";
        boolean vazio = true;
        if (!listaAtendimento.isEmpty()) {
            texto += "\nAtendimentos:\n";
            vazio = false;
            for (Atendimento a : listaAtendimento) {
                texto += a.toString();
            }
        }

        if (!vazio) {
            textoArea.setText(texto);
        } else {
            new JanelaDeErro("Erro: Não há nenhum dado cadastrado");
        }
    }

}

package interfaces;

import aplicacao.ACMEAtendimento;
import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        mostrarAtendimento();
    }

    public JPanel getPainel() { return painel; }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botaoConfirma) {
            String texto = "";
            String at = insereAtend.getText();

            for(Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getCod() == Integer.parseInt(at)) {
                    texto += "Atendimento: " + a.getCod() + "\n";
                }
            }

            if(atendimento != null) {
                textoArea.setText(texto);
            } else {
                new JanelaDeErro("Erro: Atendimento não encontrado");
            }
        }


        //FECHAR BOTAO
        if (e.getSource() == fecharBotao) {
            this.dispose();
        }

    }


    public void mostrarAtendimento() {
        String texto = "";
        boolean vazio = true;
        if (!acmeAtendimento.getAtendimentos().isEmpty()) {
            vazio = false;
            for (Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getEquipe() != null) {
                    texto += "Atendimento: " + a.getCod() + "\n";
                    //texto += "Equipe: " + a.getEquipe().getNome() + "\n";
                    //texto += "Evento: " + a.getEvento().getNome() + "\n";
                    texto += "Status: " + a.getStatus() + "\n";
                    texto += "-----------------------------------\n";
                }

            }

        }
        if(vazio) {
            texto = "Não há nenhum atendimento cadastrado";
            textoArea.setText(texto);
        }
        if(!vazio) {
            textoArea.setText(texto);

        } else {
            new JanelaDeErro("Erro: Não há nenhum atendimento cadastrado");
        }

    }

}

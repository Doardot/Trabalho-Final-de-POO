package interfaces;

import aplicacao.ACMEAtendimento;
import dados.Atendimento.Atendimento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarSituacaoAtendimento extends JFrame implements ActionListener {

    private ACMEAtendimento acmeatendimento;
    private Atendimento atendimento;
    private JPanel painel;
    private JLabel alteraSitu;
    private JButton fecharBotao;
    private JTextField tituloAtend;

    private JTextArea textoArea;
    private JLabel atendTitulo;
    private JTextField insereAtend;
    private JButton botaoConfirma;

    public AlterarSituacaoAtendimento(ACMEAtendimento atendimento) {
        this.acmeatendimento = atendimento;

        this.add(painel);
        this.setSize(800, 400);
        this.dispose();
        this.setVisible(true);

        painel.setVisible(true);
        atendTitulo.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        insereAtend.addActionListener(this);
        fecharBotao.addActionListener(this);

        //mostrarAtendimento();
    }

    public JPanel getPainel() { return painel; }


    public void actionPerformed(ActionEvent e){

        if(e.getSource() == botaoConfirma) {
            String at = insereAtend.getText();

            for(Atendimento atendimento : acmeatendimento.getAtendimentos()) {
                if(atendimento.getCod() == Integer.parseInt(at)) {
                    textoArea.append("Atendimento: " + atendimento + "\n");
                }
            }
        }




        if (e.getSource() == fecharBotao) {
            this.dispose();
        }

    }


}

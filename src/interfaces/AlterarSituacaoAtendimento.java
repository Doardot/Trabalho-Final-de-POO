package interfaces;

import aplicacao.ACMEAtendimento;
import dados.Atendimento.Atendimento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }

    public JPanel getPainel() { return painel; }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == mostrarAtend) {
            //todo
        }
        if(e.getSource() == botaoConfirma) {
            String texto = "";
            String at = insereAtend.getText();
            String atNovo = insereAtendNovo.getText();

            for(Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getCod() == Integer.parseInt(at)) {
                    texto += "Atendimento: " + a;
                }
            }


            if(!texto.isBlank()){
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


}

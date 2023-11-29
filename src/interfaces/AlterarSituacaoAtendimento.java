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

    private JTextArea textoArea;
    private JLabel atendTitulo;
    private JTextField insereAtend;
    private JButton botaoConfirma;

    //A FAZER
    public AlterarSituacaoAtendimento(ACMEAtendimento atendimento) {
        this.acmeAtendimento = atendimento;

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

            for(Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getCod() == Integer.parseInt(at)) {
                    textoArea.append("Atendimento: " + a.getCod() + "\n");
                    mostrarAtendimento();
                }
            }


        }




        if (e.getSource() == fecharBotao) {
            this.dispose();
        }

    }

    public void mostrarAtendimento() {
        /*String texto = "";
        boolean vazio = true;*/
        if (!acmeAtendimento.getAtendimentos().isEmpty()) {
            //vazio = false;
            for (Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getEquipe() != null) {
                    textoArea.append("Equipe alocada: " + a.getEquipe().toString() + "\n");
                }
                textoArea.append(a + "\n");
            }
        }

        /*if (!vazio) {
            areaTexto.setText(texto);*/
        else {
            new JanelaDeErro("Erro: Não há nenhum atendimento cadastrado");
        }
    }


}

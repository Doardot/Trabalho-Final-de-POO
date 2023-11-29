package interfaces;

import aplicacao.ACMEAtendimento;
import dados.Atendimento.Atendimento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultarAtendimento extends JFrame implements ActionListener {

    private Atendimento atendimento;
    private ACMEAtendimento acmeAtendimento;
    private JLabel titulo;
    private JPanel painel;
    private JTextArea areaTexto;
    private JButton fecharBotao;

    public ConsultarAtendimento(ACMEAtendimento acmeAtendimento) {
        this.add(painel);
        this.acmeAtendimento = acmeAtendimento;

        this.setSize(800, 400);
        this.dispose();
        this.setVisible(true);

        this.add(painel);
        painel.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        fecharBotao.addActionListener(this);

        mostrarAtendimento();
    }

    public JPanel getPainel() { return painel; }

    public void mostrarAtendimento() {
        /*String texto = "";
        boolean vazio = true;*/
        if (!acmeAtendimento.getAtendimentos().isEmpty()) {
            //vazio = false;
            for (Atendimento a : acmeAtendimento.getAtendimentos()) {
                if(a.getEquipe() != null) {
                    areaTexto.append("Equipe alocada: " + a.getEquipe().toString() + "\n");
                }
                areaTexto.append(a + "\n");
            }
        }

        /*if (!vazio) {
            areaTexto.setText(texto);*/
        else {
            new JanelaDeErro("Erro: Não há nenhum atendimento cadastrado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fecharBotao) {
            this.dispose();
        }
    }
}

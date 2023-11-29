package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;
import dados.Evento.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FormularioAtendimento extends JFrame implements ActionListener {
    private JPanel painel;
    private JPanel campoTexto;
    private JTextField codText;
    private JFormattedTextField dataText;
    private JTextField duracaoText;
    private JLabel codLab;
    private JLabel dataLab;
    private JLabel duracaoLab;
    private JLabel precLab;
    private JPanel clicaveis;
    private JButton okBot;
    private JButton limpaBot;
    private JButton mostraBot;
    private JButton acabaBot;
    private JPanel areaTexto;
    private JTextArea textArea;
    private JComboBox escolheEvento;
    private ACMEAtendimento acmeAtendimento;
    private ACMEEquipe acmeEquipe;
    private ACMEEvento acmeEvento;
    private String eventoStr;

    public FormularioAtendimento(ACMEAtendimento acmeAtendimento, ACMEEquipe acmeEquipe, ACMEEvento acmeEvento) {
        this.acmeAtendimento = acmeAtendimento;
        this.acmeEquipe = acmeEquipe;
        this.acmeEvento = acmeEvento;

        okBot.addActionListener(this);
        limpaBot.addActionListener(this);
        acabaBot.addActionListener(this);

        this.add(painel);
        this.pack();
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okBot) {
            eventoStr = (String) escolheEvento.getSelectedItem();
            String dataStr = dataText.getText();
            int codInt = 0;
            int durInt = 0;

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                formatter.parse(dataStr);
            } catch (ParseException exception) {
                new JanelaDeErro("ERRO. DATA INVALIDA (dd/MM/yyyy).");
                return;
            }

            if (dataStr.equals("")) {
                new JanelaDeErro("ERRO. CAMPO DE DATA VAZIO");
                return;
            }

            try {
                codInt = Integer.parseInt(codText.getText());
                if (codInt <= 0) {
                    new JanelaDeErro("ERRO. CÓDIGO INVÁLIDO.");
                    return;
                }
                durInt = Integer.parseInt(duracaoText.getText());
                if (durInt <= 0) {
                    new JanelaDeErro("ERRO. LATITUDE INVÁLIDA (entre -90 e 90).");
                    return;
                }
            } catch (NumberFormatException exception) {
                new JanelaDeErro("ERRO. CAMPO VAZIO OU NÚMERO INVÁLIDO.");
                return;
            }

            Evento evento = null;
            for (int i = 0; i < acmeEvento.getEventos().size(); i++) {
                if (acmeEvento.getEventos().get(i).toString().trim().equals(eventoStr)) {
                    evento = acmeEvento.getEventos().get(i);
                }
            }

            if (evento == null) {
                new JanelaDeErro("ERRO. EVENTO NÃO EXISTE.");
            }
            Atendimento atendimento = new Atendimento(codInt, dataStr, durInt, null, evento, AtendimentoStatus.PEN);
            if (acmeAtendimento.cadastraAtendimento(atendimento)) {
                new JanelaDeErro("ATENDIMENTO ADICIONADO.");
                evento.setEstaDisponivel(false);
                acmeAtendimento.alocaEquipe(acmeEquipe.getEquipes());
                this.dispose();
                FormularioAtendimento formAtendimento = new FormularioAtendimento(acmeAtendimento, acmeEquipe, acmeEvento);
            } else {
                new JanelaDeErro("ATENDIMENTO NÃO ADICIONADO. POIS ESTE CÓDIGO JÁ EXISTE.");
            }
        }
        if (e.getSource() == limpaBot) {
            codText.setText("");
            dataText.setText("");
            duracaoText.setText("");
        }
        if (e.getSource() == acabaBot) {
            this.dispose();
        }
    }

    private void createUIComponents() {
        try {
            ArrayList<Evento> eventos = acmeEvento.getEventos();
            String[] opcoesComboBox = new String[eventos.size()];

            for (int i = 0; i < eventos.size(); i++) {
                if (eventos.get(i).getEstaDisponivel()) {
                    opcoesComboBox[i] = eventos.get(i).toString();
                }
            }
            escolheEvento = new JComboBox<>(opcoesComboBox);
        } catch (NullPointerException e) {
            System.out.println("ERRO. MOSTRAR EVENTO." + e.getMessage());
        }

        try {
            dataText = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch (ParseException e) {
            String str = textArea.getText();
            str += "ERRO. FORMATADOR DE DATA.\n";
            textArea.setText(str);
        }
    }

}

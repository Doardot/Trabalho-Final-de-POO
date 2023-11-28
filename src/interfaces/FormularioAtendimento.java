package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;
import dados.Equipe.*;
import dados.Evento.*;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
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

    public FormularioAtendimento(ACMEAtendimento acmeAtendimento, ACMEEquipe acmeEquipe, ACMEEvento acmeEvento) {
        this.acmeAtendimento = acmeAtendimento;
        this.acmeEquipe = acmeEquipe;
        this.acmeEvento = acmeEvento;

        escolheEvento = new JComboBox<>();

        this.add(painel);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okBot) {
            String eventoStr = (String) escolheEvento.getSelectedItem();
            String dataStr = dataText.getText();
            int codInt = 0;
            int durInt = 0;

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                formatter.parse(dataStr);
            } catch (ParseException exception) {
                String str = textArea.getText();
                str += "ERRO. DATA INVALIDA (dd/MM/yyyy).\n";
                textArea.setText(str);
                new JanelaDeErro("\"ERRO. DATA INVALIDA (dd/MM/yyyy).\\n\"");
                return;
            }

            if (dataStr.equals("")) {
                String str = textArea.getText();
                str += "ERRO. CAMPO DE DATA VAZIO.\n";
                textArea.setText(str);
                return;
            }

            try {
                codInt = Integer.parseInt(codText.getText());
                if (codInt <= 0) {
                    String str = textArea.getText();
                    str += "ERRO. CÓDIGO INVÁLIDO.\n";
                    textArea.setText(str);
                    return;
                }
                durInt = Integer.parseInt(duracaoText.getText());
                if (durInt <= 0) {
                    String str = textArea.getText();
                    str += "ERRO. LATITUDE INVÁLIDA (entre -90 e 90).\n";
                    textArea.setText(str);
                    return;
                }
            } catch (NumberFormatException exception) {
                String str = textArea.getText();
                str += "ERRO. CAMPO VAZIO OU NÚMERO INVÁLIDO.\n";
                textArea.setText(str);
                return;
            }

            Evento evento = null;
            for (Evento ev : acmeEvento.getEventos()) {
                if (ev.toString().equals(eventoStr)) {
                    evento = ev;
                }
            }

            String str = textArea.getText();
            if (evento == null) {
                str = "ERRO. EVENTO NÃO EXISTE.";
                str += evento.toString() + "\n";
                textArea.setText(str);
            }
            Atendimento atendimento = new Atendimento(codInt, dataStr, durInt, null, evento, AtendimentoStatus.PEN);
            if (acmeAtendimento.cadastraAtendimento(atendimento)) {
                str = "ATENDIMENTO ADICIONADO: ";
                str += evento.toString() + "\n";
                textArea.setText(str);
            } else {
                str += "ATENDIMENTO NÃO ADICIONADO. POIS ESTE CÓDIGO JÁ EXISTE. \n";
                textArea.setText(str);
            }
        }

        if (e.getSource() == acabaBot) {
            this.dispose();
        }
    }

    private void createUIComponents() {
        try {
            ArrayList<Evento> eventos = acmeEvento.getEventos();
            String[] opcoesComboBox = new String[eventos.size()];

            for (int i = 0; i < eventos.size() - 1; i++) {
                opcoesComboBox[i] = eventos.get(i).toString();
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
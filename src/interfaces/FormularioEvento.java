package interfaces;

import aplicacao.*;
import dados.Evento.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormularioEvento extends JFrame implements ActionListener, ItemListener {
    private ACMEEvento acmeEvento;
    private JPanel painel;
    private JTextField codText;
    private JFormattedTextField dataText;
    private JTextField precText;
    private JTextField latText;
    private JTextField velText;
    private JTextField lonText;
    private JComboBox comboBox;
    private JButton okBot;
    private JButton limpaBot;
    private JButton mostraBot;
    private JButton acabaBot;
    private JPanel clicaveis;
    private JPanel areaTexto;
    private JPanel campoTexto;
    private JLabel codLab;
    private JLabel dataLab;
    private JLabel latLab;
    private JLabel lonLab;
    private JLabel velLab;
    private JLabel precLab;
    private JTextField magText;
    private JLabel magLab;
    private JTextField estText;
    private JLabel estLab;
    private JTextArea textArea;

    public FormularioEvento(ACMEEvento eventos) {
        this.add(painel);
        this.pack();
        this.dispose();
        this.setVisible(true);
        this.acmeEvento = eventos;

        magLab.setVisible(false);
        magText.setVisible(false);
        estLab.setVisible(false);
        estText.setVisible(false);

        okBot.addActionListener(this);
        mostraBot.addActionListener(this);
        limpaBot.addActionListener(this);
        acabaBot.addActionListener(this);
        comboBox.addItemListener(this);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okBot) {
            Evento evento = null;
            String codStr = codText.getText();

            String dataStr = dataText.getText();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            formatter.setLenient(false);
            try {
                formatter.parse(dataStr);
            } catch (ParseException exception) {
                String str = textArea.getText();
                str += "ERRO. DATA INVALIDA (dd/MM/yyyy).\n";
                textArea.setText(str);
                return;
            }

            if (codStr .equals("") || dataStr .equals((""))) {
                String str = textArea.getText();
                str += "ERRO. CAMPO VAZIO.\n";
                textArea.setText(str);
                return;
            }
            try {
                double latDbl = Double.parseDouble(latText.getText());
                double lonDbl = Double.parseDouble(lonText.getText());
                if (latDbl < -90 || latDbl > 90) {
                    String str = textArea.getText();
                    str += "ERRO. LATITUDE INVÁLIDA (entre -90 e 90).\n";
                    textArea.setText(str);
                    return;
                }
                if (latDbl < -180 || latDbl > 180) {
                    String str = textArea.getText();
                    str += "ERRO. LONGITUDE INVÁLIDA (entre -180 e 180).\n";
                    textArea.setText(str);
                    return;
                }
                if(comboBox.getSelectedItem().toString() .equals ("Ciclone")) {
                    double velDbl = Double.parseDouble(velText.getText());
                    double precDbl = Double.parseDouble(precText.getText());
                    if (velDbl < 0 || precDbl < 0) {
                        String str = textArea.getText();
                        str += "ERRO. NUMERO INVÁLIDO.\n";
                        textArea.setText(str);
                        return;
                    }
                    evento = new Ciclone(codStr, dataStr, latDbl, lonDbl, velDbl, precDbl);
                }
                else if (comboBox.getSelectedItem().toString() .equals ("Terremoto")) {
                    double magDbl = Double.parseDouble(magText.getText());
                    if (magDbl < 0) {
                        String str = textArea.getText();
                        str += "ERRO. NUMERO INVÁLIDO.\n";
                        textArea.setText(str);
                        return;
                    }
                    evento = new Terremoto(codStr, dataStr, latDbl, lonDbl, magDbl);
                }

                else if (comboBox.getSelectedItem().toString() .equals ("Seca")) {
                    int estInt = Integer.parseInt(estText.getText());
                    if (latDbl < 0 || lonDbl < 0) {
                        String str = textArea.getText();
                        str += "ERRO. NUMERO INVÁLIDO.\n";
                        textArea.setText(str);
                        return;
                    }
                    evento = new Seca(codStr, dataStr, latDbl, lonDbl, estInt);
                }
            } catch (NumberFormatException exception) {
                String str = textArea.getText();
                str += "ERRO. CAMPO VAZIO OU NÚMERO INVÁLIDO.\n";
                textArea.setText(str);
                return;
            }

            String str = textArea.getText();
            try {
                acmeEvento.cadastraEvento(evento);
                str += "EVENTO ADICIONADO: ";
                str += evento.toString() + "\n";
                textArea.setText(str);
            } catch (Exception exception){
                str += "EVENTO NÃO ADICIONADO. POIS ESTE CÓDIGO JÁ EXISTE. \n";
                textArea.setText(str);
            }
        }

        else if(e.getSource() == limpaBot) {
            codText.setText("");
            dataText.setText("");
            latText.setText("");
            lonText.setText("");
            velText.setText("");
            precText.setText("");
            magText.setText("");
            estText.setText("");
            textArea.setText("");
        }

        else if(e.getSource() == acabaBot) {
            this.dispose();
        }


        /*
        else if(e.getSource() == mostraBot) {
            String str = textArea.getText() + "";
            acmeRescue.reset();
            if (!acmeRescue.hasNext()) {
                str += "NUNHUM DADO CADASTRADO \n";
                textArea.setText(str);
                return;
            }
            str += " ----------DADOS-JÁ-CADASTRADOS-------------------------------------------------------------- \n";
            while(acmeRescue.hasNext()) {
                Evento evento = acmeRescue.next();
                str += evento.toString() + "\n";
            }
            textArea.setText(str);
        }

        else if(e.getSource() == acabaBot) {
            System.exit(0);
        }
        */
    }

    public void itemStateChanged(ItemEvent arg0) {
        if(comboBox.getSelectedItem().toString() .equals ("Ciclone")) {
            velLab.setVisible(true);
            velText.setVisible(true);
            precLab.setVisible(true);
            precText.setVisible(true);
            magLab.setVisible(false);
            magText.setVisible(false);
            estLab.setVisible(false);
            estText.setVisible(false);
            magText.setText("");
            estText.setText("");
        }
        else if (comboBox.getSelectedItem().toString() .equals ("Terremoto")) {
            velLab.setVisible(false);
            velText.setVisible(false);
            precLab.setVisible(false);
            precText.setVisible(false);
            magLab.setVisible(true);
            magText.setVisible(true);
            estLab.setVisible(false);
            estText.setVisible(false);
            velText.setText("");
            precText.setText("");
            estText.setText("");
        }
        else if (comboBox.getSelectedItem().toString() .equals ("Seca")) {
            velLab.setVisible(false);
            velText.setVisible(false);
            precLab.setVisible(false);
            precText.setVisible(false);
            magLab.setVisible(false);
            magText.setVisible(false);
            estLab.setVisible(true);
            estText.setVisible(true);
            velText.setText("");
            precText.setText("");
            magText.setText("");
        }
    }

    private void createUIComponents() {
        try {
            dataText = new JFormattedTextField(new MaskFormatter("##/##/####"));
        }catch (ParseException e) {
            String str = textArea.getText();
            str += "ERRO. FORMATADOR DE DATA.\n";
            textArea.setText(str);
        }
    }
}


package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Atendimento.Atendimento;
import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;
import dados.Equipamento.Equipamento;
import dados.Equipamento.Escavadeira;
import dados.Equipe.Equipe;
import dados.Evento.Ciclone;
import dados.Evento.Evento;
import dados.Evento.Seca;
import dados.Evento.Terremoto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class SalvarDados extends JFrame implements ActionListener {
    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private ACMEEquipamento equipamento;
    private JLabel salvarTexto;
    private JTextField textField1;
    private JButton cadastrarButton;
    private JPanel janela;
    private JComboBox seletorBox;

    private Scanner entrada = null;
    private PrintStream saidaPadrao = System.out;

    public SalvarDados(ACMEEquipe equipe, ACMEEvento evento, ACMEAtendimento atendimento, ACMEEquipamento equipamento) {
        this.equipe = equipe;
        this.evento = evento;
        this.atendimento = atendimento;
        this.equipamento = equipamento;
        setContentPane(janela);
        this.setSize(450, 200);
        this.setVisible(true);
        cadastrarButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {




        if (e.getSource() == cadastrarButton) {

            String texto = "";




            String seletor = (String) seletorBox.getSelectedItem();
            assert seletor != null;
            String arquivo = textField1.getText();
            arquivo = "src/" + arquivo + ".csv";
            PrintStream streamSaida = null;
            try {
                streamSaida = new PrintStream(new File(arquivo), Charset.forName("UTF-8"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.setOut(streamSaida);

            switch (seletor) {
                case "Atendimento" -> {
                    ArrayList<Atendimento> listaAtendimento;
                    listaAtendimento = atendimento.getAtendimentos();


                    if (!listaAtendimento.isEmpty()) {
                        for (Atendimento a : listaAtendimento) {
                            texto += a.toStringDados();
                        }
                    }




                }

                case "Equipamento" -> {
                    ArrayList<Equipamento> listaEquipamento;
                    listaEquipamento = equipamento.getLista();

                    if (!listaEquipamento.isEmpty()) {
                        for (Equipamento equipamento : listaEquipamento) {
                            texto += equipamento.toStringDados();
                        }
                    }
                }



                case "Evento" -> {
                    ArrayList<Evento> listaEvento;
                    listaEvento = evento.getEventos();
                    if (!listaEvento.isEmpty()) {
                        for (Evento evento : listaEvento) {
                            texto += evento.toStringDados();
                        }
                    }


                }
                case "Equipe" -> {
                    ArrayList<Equipe> listaEquipe;
                    listaEquipe = equipe.getEquipes();

                    if (!listaEquipe.isEmpty()) {
                        for (Equipe equipe : listaEquipe) {
                            texto += equipe.toStringDados();
                        }
                    }

                }
            }
            System.out.println(texto);
        }

    }

}



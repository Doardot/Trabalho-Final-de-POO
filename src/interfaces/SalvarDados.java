package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
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
            String arquivo = "";
            arquivo = textField1.getText();
            if (!arquivo.isBlank()) {
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
                        new JanelaDeErro("Arquivos atualizados");


                    }

                    case "Equipamento" -> {
                        ArrayList<Equipamento> listaEquipamento;
                        listaEquipamento = equipamento.getLista();

                        if (!listaEquipamento.isEmpty()) {
                            for (Equipamento equipamento : listaEquipamento) {
                                texto += equipamento.toStringDados();
                            }
                        }
                        new JanelaDeErro("Arquivos atualizados");
                    }


                    case "Evento" -> {
                        ArrayList<Evento> listaEvento;
                        listaEvento = evento.getEventos();
                        if (!listaEvento.isEmpty()) {
                            for (Evento evento : listaEvento) {
                                texto += evento.toStringDados();
                            }
                        }
                        new JanelaDeErro("Arquivos atualizados");

                    }
                    case "Equipe" -> {
                        ArrayList<Equipe> listaEquipe;
                        listaEquipe = equipe.getEquipes();

                        if (!listaEquipe.isEmpty()) {
                            for (Equipe equipe : listaEquipe) {
                                texto += equipe.toStringDados();
                            }
                        }
                        new JanelaDeErro("Arquivos atualizados");
                    }
                }
                System.out.println(texto);
            }
        }
    }

}



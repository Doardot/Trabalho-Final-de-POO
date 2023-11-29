package interfaces;


import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;

import dados.Atendimento.Atendimento;
import dados.Atendimento.AtendimentoStatus;
import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;

import dados.Equipamento.Escavadeira;
import dados.Equipe.Equipe;
import dados.Evento.Ciclone;
import dados.Evento.Evento;
import dados.Evento.Seca;
import dados.Evento.Terremoto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraDeArquivos extends JFrame implements ActionListener, ItemListener {
    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private ACMEEquipamento equipamento;
    private JPanel janela;
    private JButton button1;
    private JLabel dadosTexto;
    private JTextField textField1;
    private JLabel insiraTexto;
    private JComboBox seletorBox;

    public LeituraDeArquivos(ACMEEquipe equipe, ACMEEvento evento, ACMEAtendimento atendimento, ACMEEquipamento equipamento) {
        this.equipe = equipe;
        this.evento = evento;
        this.atendimento = atendimento;
        this.equipamento = equipamento;
        setContentPane(janela);
        this.setSize(450, 200);
        this.setVisible(true);
        button1.addActionListener(this);
        seletorBox.addItemListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            String seletor = (String) seletorBox.getSelectedItem();
            assert seletor != null;
            String arquivo = textField1.getText();
            arquivo = "src/" + arquivo + ".csv";

            switch (seletor) {
                case "Atendimento" -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        AtendimentoStatus status = null;
                        while ((linha = br.readLine()) != null) {
                            String[] dados = linha.split(";");
                            int cod = Integer.parseInt(dados[0]);
                            String dataInicio = dados[1];
                            int duracao = Integer.parseInt(dados[2]);
                            if(dados[3].equals("PENDENTE")){
                                status = AtendimentoStatus.PEN;
                            } else if (dados[3].contains("EXECUTANDO")) {
                                status = AtendimentoStatus.EX;
                            }
                            else if(dados[3].equals("FINALIZADO")) {
                                status = AtendimentoStatus.FIN;
                            }
                            else if(dados[3].equals("CANCELADO")) {
                                status = AtendimentoStatus.CANCEL;
                            }

                            String codigo = dados[4];
                            for(Evento eventoAux : evento.getEventos()) {
                                if(eventoAux.getCodigo().equals(codigo) ) {

                                    atendimento.cadastraAtendimento(new Atendimento(cod, dataInicio, duracao, null, eventoAux, status ));
                                }
                                else{
                                    Atendimento atendimento1 = new Atendimento(cod, dataInicio, duracao, null, null, status);
                                    atendimento1.setCodigo(codigo);
                                    atendimento.cadastraAtendimento(atendimento1);
                                }
                            }




                        }
                        new JanelaDeErro("Cadastrado com sucesso");
                    } catch (IOException x) {
                        new JanelaDeErro("Erro: Arquivo não encontrado");

                    }
                }

                case "Equipamento" -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            String[] dados = linha.split(";");
                            int id = Integer.parseInt(dados[0]);
                            String nome = dados[1];
                            double custodia = Double.parseDouble(dados[2]);
                            String codinome = dados[3];
                            int tipo = Integer.parseInt(dados[4]);

                            if (tipo == 1) { // Barco
                                int capacidade = Integer.parseInt(dados[5]);
                                Barco barco = new Barco(id, nome, custodia, capacidade);
                                barco.setCodinome(codinome);
                                equipamento.adicionaEquipamento(barco);
                            }
                            if (tipo == 2) { // Caminhao
                                double capacidade = Double.parseDouble(dados[5]);
                                CaminhaoTanque caminhao = new CaminhaoTanque(id, nome, custodia, capacidade);
                                caminhao.setCodinome(codinome);
                                equipamento.adicionaEquipamento(caminhao);
                            }
                            if (tipo == 3) { // Escavadeira
                                String combustivel = dados[5];
                                double carga = Double.parseDouble(dados[6]);
                                Escavadeira escavadeira = new Escavadeira(id, nome, custodia, combustivel, carga);
                                escavadeira.setCodinome(codinome);
                                equipamento.adicionaEquipamento(escavadeira);

                            }
                        }
                        new JanelaDeErro("Cadastrado com sucesso");
                    } catch (Exception x) {
                        new JanelaDeErro("Erro: Arquivo não encontrado");


                    }
                }

                case "Evento" -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            String[] dados = linha.split(";");
                            String codigo = dados[0];
                            String data = dados[1];
                            double latitude = Double.parseDouble(dados[2]);
                            double longitude = Double.parseDouble(dados[3]);
                            int tipo = Integer.parseInt(dados[4]);

                            if (tipo == 1) { // Ciclone
                                double velocidade = Double.parseDouble(dados[5]);
                                double precipitacao = Double.parseDouble(dados[6]);
                                evento.cadastraEvento(new Ciclone(codigo, data, latitude, longitude, velocidade, precipitacao));
                            }
                            if (tipo == 2) { // Terrometo
                                double magnitude = Double.parseDouble(dados[5]);
                                evento.cadastraEvento(new Terremoto(codigo, data, latitude, longitude, magnitude));
                            }
                            if (tipo == 3) { // Seca
                                int estiagem = Integer.parseInt(dados[5]);
                                evento.cadastraEvento(new Seca(codigo, data, latitude, longitude, estiagem));

                            }
                        }
                        new JanelaDeErro("Cadastrado com sucesso");
                    } catch (Exception x) {
                        new JanelaDeErro("Erro: Arquivo não encontrado");

                    }

                }
                case "Equipe" -> {
                    try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            String[] dados = linha.split(";");

                            String codinome = dados[0];
                            int quantidade = Integer.parseInt(dados[1]);
                            double latitude = Double.parseDouble(dados[2]);
                            double longitude = Double.parseDouble(dados[3]);

                            equipe.addEquipe(new Equipe(codinome, quantidade, latitude, longitude, null));

                        }
                        new JanelaDeErro("Cadastrado com sucesso");
                    } catch (Exception x) {
                        new JanelaDeErro("Erro: Arquivo não encontrado");

                    }


                }


            }

        }


    }




    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}

          /*  String arquivo = textField1.getText();
            arquivo =  "src/"+ arquivo+ ".csv";
            System.out.println(arquivo);
            if (arquivo.equals("src/EXEMPLO-ATENDIMENTOS.csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");
                        int cod = Integer.parseInt(dados[0]);
                        String dataInicio = dados[1];
                        int duracao = Integer.parseInt(dados[2]);
                        String status = dados[3];


                    }
                    new JanelaDeErro("Cadastrado com sucesso");
                } catch (IOException x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }
            }*/
        /*   else if(arquivo.equals("src/EXEMPLO-EQUIPAMENTOS.csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");
                        int id = Integer.parseInt(dados[0]);
                        String nome = dados[1];
                        double custodia = Double.parseDouble(dados[2]);
                        String Codinome = dados[3];
                        int tipo = Integer.parseInt(dados[4]);

                        if (tipo == 1) { // Barco
                            int capacidade = Integer.parseInt(dados[5]);
                            equipamento.adicionaEquipamento(new Barco(id, nome, custodia, capacidade));
                        }
                        if (tipo == 2) { // Caminhao
                            double capacidade = Double.parseDouble(dados[5]);
                            equipamento.adicionaEquipamento(new CaminhaoTanque(id, nome, custodia, capacidade));
                        }
                        if (tipo == 3) { // Escavadeira
                            String combustivel = dados[5];
                            double carga = Double.parseDouble(dados[6]);
                            equipamento.adicionaEquipamento(new Escavadeira(id, nome, custodia, combustivel, carga));

                        }
                    }
                    new JanelaDeErro("Cadastrado com sucesso");
                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");


                }
            }

            else if(arquivo.equals("src/EXEMPLO-EQUIPES.csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");

                        String codinome = dados[0];
                        int quantidade = Integer.parseInt(dados[1]);
                        double latitude = Double.parseDouble(dados[2]);
                        double longitude = Double.parseDouble(dados[3]);

                        equipe.addEquipe(new Equipe(codinome, quantidade, latitude, longitude, null));

                    }
                    new JanelaDeErro("Cadastrado com sucesso");
                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }


            }   */
/*
            else if(arquivo.equals("src/EXEMPLO-EVENTOS.csv")) {
                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] dados = linha.split(";");
                        String codigo = dados[0];
                        String data = dados[1];
                        double latitude = Double.parseDouble(dados[2]);
                        double longitude = Double.parseDouble(dados[3]);
                        int tipo = Integer.parseInt(dados[4]);

                        if(tipo == 1 ) { // Ciclone
                            double velocidade = Double.parseDouble(dados[5]);
                            double precipitacao = Double.parseDouble(dados[6]);
                            evento.cadastraEvento(new Ciclone(codigo, data, latitude, longitude, velocidade, precipitacao));
                        }
                        if(tipo ==2) { // Terrometo
                            double magnitude = Double.parseDouble(dados[5]);
                            evento.cadastraEvento(new Terremoto(codigo, data, latitude, longitude, magnitude));
                        }
                        if(tipo==3) { // Seca
                            int estiagem = Integer.parseInt(dados[5]);
                            evento.cadastraEvento(new Seca(codigo, data, latitude, longitude,estiagem));

                        }
                    }
                    new JanelaDeErro("Cadastrado com sucesso");
                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }

            }
            else{
                new JanelaDeErro("Erro: Arquivo não encontrado");
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == seletorBox){
            String seletor = (String) seletorBox.getSelectedItem();
            assert seletor != null;
            switch (seletor) {
                case "Atendimento" -> {

                }



                }


        }
        else if(){

        }
        else if(){

        }


    }
}
*/
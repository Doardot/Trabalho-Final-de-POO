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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JanelaPrincipal extends JFrame implements ActionListener {
    private ACMEEquipe equipe;
    private ACMEEvento evento;
    private ACMEAtendimento atendimento;
    private ACMEEquipamento equipamento;
    private JButton equipamentoBotao;
    private JButton fecharBotao;
    private JButton equipeBotao;
    private JButton eventoBotao;
    private JButton atendimentoBotao;
    private JPanel JanelaPrincipal;
    private JLabel tituloTrab;
    private JButton relatorioGeral;
    private JButton leituraArquivo;
    private JButton vinculaEquipamento;
    private JButton consulAtend;
    private JButton alteraAtend;
    private JButton salvarDados;
    private JButton carregarDados;


    public JanelaPrincipal() {
        equipe = new ACMEEquipe();
        evento = new ACMEEvento();
        atendimento = new ACMEAtendimento();
        equipamento = new ACMEEquipamento();

        this.setVisible(true);
        this.add(JanelaPrincipal);
        this.setSize(700,600);
        atendimentoBotao.addActionListener(this);
        eventoBotao.addActionListener(this);
        equipeBotao.addActionListener(this);
        equipamentoBotao.addActionListener(this);
        consulAtend.addActionListener(this);
        alteraAtend.addActionListener(this);
        relatorioGeral.addActionListener(this);
        leituraArquivo.addActionListener(this);
        vinculaEquipamento.addActionListener(this);
        salvarDados.addActionListener(this);
        carregarDados.addActionListener(this);
        fecharBotao.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == atendimentoBotao) {
            FormularioAtendimento formAtendimento = new FormularioAtendimento(atendimento, equipe, evento);
        }
        if(e.getSource() == eventoBotao) {
            FormularioEvento formEvento = new FormularioEvento(evento);
        }
        if(e.getSource() == equipeBotao) {
            FormularioEquipe formEquipe = new FormularioEquipe(equipe, atendimento);
        }
        if(e.getSource() == equipamentoBotao) {
            FormularioEquipamento formEquipamento = new FormularioEquipamento(equipamento);
        }
        if(e.getSource()== vinculaEquipamento) {
            VinculaEquipamento vinculaEquipamento1 = new VinculaEquipamento(equipe, equipamento);
        }
        if(e.getSource() == consulAtend) {
            ConsultarAtendimento consultarAtendimento = new ConsultarAtendimento(atendimento);
        }
        if(e.getSource() == alteraAtend) {
            AlterarSituacaoAtendimento aSA = new AlterarSituacaoAtendimento(atendimento);
        }
        if(e.getSource() == relatorioGeral) {
            RelatorioGeral relatorioGeral1 = new RelatorioGeral(equipe, evento, atendimento, equipamento);
        }
        if(e.getSource() == leituraArquivo) {
            LeituraDeArquivos leituraDeArquivosForm = new LeituraDeArquivos(equipe, evento, atendimento, equipamento);
        }
        if(e.getSource() == salvarDados) {
            SalvarDados salvarDados1 = new SalvarDados(equipe, evento, atendimento, equipamento);
        }
        if(e.getSource() == carregarDados) {
            carregarDados("src/EXEMPLO-EQUIPES.csv");
            carregarDados("src/EXEMPLO-EVENTOS.csv");
            carregarDados("src/EXEMPLO-EQUIPAMENTOS.csv");
            carregarDados("src/EXEMPLO-ATENDIMENTOS.csv");
            new JanelaDeErro("Dados inicializados");

        }
        if(e.getSource() == fecharBotao) {
            System.exit(0);
        }
    }

    public void carregarDados(String arquivo) {

        switch (arquivo) {
            case "src/EXEMPLO-ATENDIMENTOS.csv" -> {
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

                } catch (IOException x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }
            }

            case "src/EXEMPLO-EQUIPAMENTOS.csv" -> {
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

                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");


                }
            }

            case "src/EXEMPLO-EVENTOS.csv" -> {
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

                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }

            }
            case "src/EXEMPLO-EQUIPES.csv" -> {
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

                } catch (Exception x) {
                    new JanelaDeErro("Erro: Arquivo não encontrado");

                }


            }


        }

    }


}












package interfaces;

import aplicacao.*;
import dados.Equipamento.Barco;
import dados.Equipamento.CaminhaoTanque;
import dados.Equipamento.Equipamento;
import dados.Equipamento.Escavadeira;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.InputMismatchException;

public class FormularioEquipamento extends JFrame implements ActionListener, ItemListener {
    private ACMEEquipamento acmeEquipamentos;
    private JLabel equipeName;
    private JPanel janelaPrincipal;
    private JLabel idPanel;
    private JLabel nomeDaEquipe;
    private JLabel custoDia;
    private JTextField idNametxt;
    private JTextField custoDiatxt;
    private JButton saveButton;
    private JTextField nomeDaEquipetxt;
    private JComboBox comboBox1;
    private JPanel painelCaminhao;
    private JPanel painelBarco;
    private JPanel painelEscavadeira;
    private JButton button1;
    private JTextField capacidadeCaminhaoText;
    private JTextField capacidadeBarcoText;
    private JLabel caminhaoTexto;
    private JTextField escavadeiraCombustivelText;
    private JTextField escavadeiraCargaText;
    private JLabel escavadeiraTexto1;
    private JLabel escavadeiraTexto2;
    private JPanel painelCaminhao2;
    private JPanel painelBarco2;
    private JPanel painelEscavadeira2;
    private JTextArea areaDeSaida;
    private JButton showList;
    private JButton exitButton;
    private JComboBox escavadeiraComboBox;


    public FormularioEquipamento(ACMEEquipamento equipamentos) {
        this.acmeEquipamentos = equipamentos;

        setContentPane(janelaPrincipal);
        this.dispose();
        setSize(800, 700);
        setVisible(true);
        saveButton.addActionListener(this);
        button1.addActionListener(this);
        showList.addActionListener(this);
        painelCaminhao.setVisible(true);
        painelEscavadeira.setVisible(false);
        painelBarco.setVisible(false);
        painelCaminhao2.setVisible(true);
        painelEscavadeira2.setVisible(false);
        painelBarco2.setVisible(false);
        comboBox1.addItemListener( this);
        escavadeiraComboBox.setVisible(false);
        exitButton.addActionListener(this);
        JScrollPane areaDeSaida = new JScrollPane();
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == saveButton) {
            int id = 0;
            String name = "";
            double custo = 0;
            boolean verifica = true;
            String texto = "";
            try {

                try {
                    id = Integer.parseInt(idNametxt.getText());
                }catch (NumberFormatException erro1){

                    texto += "Erro: Numero invalido no campo id\n";
                    verifica = false;
                }

                try {
                    name = nomeDaEquipetxt.getText();
                    if (name.equals("")) {
                        throw new InputMismatchException();
                    }
                }catch(InputMismatchException erro2) {
                    texto += "Erro: Nome nao pode ser nulo\n";
                    verifica = false;
                }

                try {
                    custo = Double.parseDouble(custoDiatxt.getText());
                }catch (NumberFormatException erro3){
                    texto += "Erro: Valor de custo invalido\n";
                    verifica = false;
                }

                String seletor = (String) comboBox1.getSelectedItem();
                assert seletor != null;


                switch (seletor) {
                    case "Caminhao" -> {
                        double capacidade = -1;
                        try {
                            capacidade = Double.parseDouble(capacidadeCaminhaoText.getText());

                        }
                        catch (NumberFormatException ei) {
                            texto += "Erro: Capacidade nao pode ser nula\n";
                            verifica = false;
                        }
                        if(capacidade > -1) {
                            if(verifica) {
                                acmeEquipamentos.adicionaEquipamento(new CaminhaoTanque(id,name,custo,capacidade));
                                //acmeEquipamentos.adicionaCaminhao(id, name, custo, capacidade);

                                texto = "Cadastrado com sucesso\n";

                            }
                        }

                    }
                    case "Barco" -> {
                        int capacidade = -1;
                        try {
                            capacidade = Integer.parseInt(capacidadeBarcoText.getText());

                        }catch (NumberFormatException eu) {
                            texto += "Erro: Capacidade nao pode ser nula\n";
                            verifica = false;
                        }
                        if(capacidade > 0) {
                            if(verifica) {
                                acmeEquipamentos.adicionaEquipamento(new Barco(id, name, custo, capacidade));

                                texto = "Cadastrado com sucesso\n";

                            }
                        }
                    }
                    case "Escavadeira" -> {
                        String combustivel = (String) escavadeiraComboBox.getSelectedItem();
                        combustivel = combustivel.toUpperCase();
                        double carga = -1;

                        try {
                            carga = Double.parseDouble(escavadeiraCargaText.getText());
                        }catch (NumberFormatException ey) {
                                texto += "Erro: Carga nao pode ser nula\n";
                                verifica = false;

                        }
                        if(carga > 0) {
                            if (verifica) {
                                acmeEquipamentos.adicionaEquipamento(new Escavadeira(id, name, custo, combustivel, carga));
                               // acmeEquipamentos.adicionaEscavadeira(id, name, custo, combustivel, carga);

                                texto = "Cadastrado com sucesso\n";

                            }
                        }

                    }

                }

            } catch (NullPointerException ex) {

                texto += "Erro: Id ja cadastrado\n";

            }
            new JanelaDeErro(texto);

        }

        if (e.getSource() == showList) {
            if (acmeEquipamentos.getLista().size() == 0) {
                String texto = areaDeSaida.getText();
                texto += "Erro: Lista vazia\n";
                areaDeSaida.setText(texto);
            }


            acmeEquipamentos.organizaLista();
            Equipamento aux = null;
            String texto = "";
            for (int i = 0; i < acmeEquipamentos.getLista().size(); i++) {
                aux = acmeEquipamentos.getLista().get(i);
                texto += aux.toString();

            }
            areaDeSaida.setText(texto);

        }


            if (e.getSource() == button1) {
                idNametxt.setText("");
                nomeDaEquipetxt.setText("");
                custoDiatxt.setText("");
                capacidadeBarcoText.setText("");
                capacidadeCaminhaoText.setText("");
                escavadeiraCargaText.setText("");
                escavadeiraCombustivelText.setText("");
                areaDeSaida.setText("");

            }

            if (e.getSource() == exitButton) {
                this.dispose();
            }
        }


        @Override
        public void itemStateChanged (ItemEvent e){
            if (e.getSource() == comboBox1) {
                String seletor = (String) comboBox1.getSelectedItem();
                assert seletor != null;
                switch (seletor) {
                    case "Caminhao" -> {
                        painelCaminhao.setVisible(true);
                        painelEscavadeira.setVisible(false);
                        painelBarco.setVisible(false);
                        painelCaminhao2.setVisible(true);
                        painelEscavadeira2.setVisible(false);
                        painelBarco2.setVisible(false);
                        escavadeiraComboBox.setVisible(false);
                    }
                    case "Barco" -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(false);
                        painelBarco.setVisible(true);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(false);
                        painelBarco2.setVisible(true);
                        escavadeiraComboBox.setVisible(false);
                    }
                    case "Escavadeira" -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(true);
                        painelBarco.setVisible(false);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(true);
                        escavadeiraComboBox.setVisible(true);
                        painelBarco2.setVisible(false);
                    }
                    default -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(false);
                        painelBarco.setVisible(false);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(false);
                        painelBarco2.setVisible(false);
                        escavadeiraComboBox.setVisible(false);
                    }
                }
            }


    }

}

































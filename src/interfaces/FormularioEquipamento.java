package interfaces;

import aplicacao.*;
import dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.InputMismatchException;

public class FormularioEquipamento extends JFrame implements ActionListener, ItemListener {

    private ACMERescue acmeRescue;
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


    public FormularioEquipamento(ACMEEquipamento equipamentos) {
        acmeRescue = new ACMERescue();

        setContentPane(janelaPrincipal);
        setTitle("Cadastra equipe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
            try {

                try {
                    id = Integer.parseInt(idNametxt.getText());
                }catch (NumberFormatException erro1){
                    String texto = areaDeSaida.getText();
                    texto += "Erro: Numero invalido no campo id\n";
                    areaDeSaida.setText(texto);
                    verifica = false;
                }

                try {
                    name = nomeDaEquipetxt.getText();
                    if (name.equals("")) {
                        throw new InputMismatchException();
                    }
                }catch(InputMismatchException erro2) {
                    String texto = areaDeSaida.getText();
                    texto += "Erro: Nome nao pode ser nulo\n";
                    areaDeSaida.setText(texto);
                    verifica = false;
                }

                try {
                    custo = Double.parseDouble(custoDiatxt.getText());
                }catch (NumberFormatException erro3){
                    String texto = areaDeSaida.getText();
                    texto += "Erro: Valor de custo invalido\n";
                    areaDeSaida.setText(texto);
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
                            String texto = areaDeSaida.getText();
                            texto += "Erro: Capacidade nao pode ser nula\n";
                            areaDeSaida.setText(texto);
                            verifica = false;
                        }
                        if(capacidade > -1) {
                            if(verifica) {
                                acmeRescue.cadastraEquipamento(new CaminhaoTanque(id, name, custo, capacidade));
                                String texto = areaDeSaida.getText();
                                texto += "Cadastrado com sucesso\n";
                                areaDeSaida.setText(texto);
                            }
                        }

                    }
                    case "Barco" -> {
                        int capacidade = -1;
                        try {
                            capacidade = Integer.parseInt(capacidadeBarcoText.getText());

                        }catch (NumberFormatException eu) {
                            String texto = areaDeSaida.getText();
                            texto += "Erro: Capacidade nao pode ser nula\n";
                            areaDeSaida.setText(texto);
                            verifica = false;
                        }
                        if(capacidade > 0) {
                            if(verifica) {
                                acmeRescue.cadastraEquipamento(new CaminhaoTanque(id, name, custo, capacidade));
                                String texto = areaDeSaida.getText();
                                texto += "Cadastrado com sucesso\n";
                                areaDeSaida.setText(texto);
                            }
                        }
                    }
                    case "Escavadeira" -> {
                        String combustivel = "";
                        double carga = -1;
                        try{
                            combustivel = escavadeiraCombustivelText.getText();
                            if(combustivel.equals("")) {
                                throw new InputMismatchException();
                            }
                        }catch (InputMismatchException i) {
                            String texto = areaDeSaida.getText();
                            texto += "Erro: Combustivel nao pode ser nulo\n";
                            areaDeSaida.setText(texto);
                            verifica = false;
                        }

                        try {
                            carga = Double.parseDouble(escavadeiraCargaText.getText());
                        }catch (NumberFormatException ey) {
                                String texto = areaDeSaida.getText();
                                texto += "Erro: Carga nao pode ser nula \n";
                                areaDeSaida.setText(texto);
                                verifica = false;

                        }
                        if(carga > 0) {
                            if (verifica) {
                                acmeRescue.cadastraEquipamento(new Escavadeira(id, name, custo, combustivel, carga));
                                String texto = areaDeSaida.getText();
                                texto += "Cadastrado com sucesso\n";
                                areaDeSaida.setText(texto);
                            }
                        }

                    }

                }

            } catch (NullPointerException ex) {
                String texto = areaDeSaida.getText();
                texto += "Erro: Id ja cadastrado\n";
                areaDeSaida.setText(texto);
            }


        }
            /*
            if (e.getSource() == showList) {
                if (acmeRescue.getLista().size() == 0) {
                    String texto = areaDeSaida.getText();
                    texto += "Erro: Lista vazia\n";
                    areaDeSaida.setText(texto);
                }


                acmeRescue.organizaLista();
                Equipamento aux = null;
                String texto = areaDeSaida.getText();
                for (int i = 0; i < acmeRescue.getLista().size(); i++) {
                    aux = acmeRescue.getLista().get(i);
                    texto += aux.toString() + "\n";

                }
                areaDeSaida.setText(texto);
            }
            */

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
                System.exit(0);
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
                    }
                    case "Barco" -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(false);
                        painelBarco.setVisible(true);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(false);
                        painelBarco2.setVisible(true);
                    }
                    case "Escavadeira" -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(true);
                        painelBarco.setVisible(false);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(true);
                        painelBarco2.setVisible(false);
                    }
                    default -> {
                        painelCaminhao.setVisible(false);
                        painelEscavadeira.setVisible(false);
                        painelBarco.setVisible(false);
                        painelCaminhao2.setVisible(false);
                        painelEscavadeira2.setVisible(false);
                        painelBarco2.setVisible(false);
                    }
                }
            }


    }

}

































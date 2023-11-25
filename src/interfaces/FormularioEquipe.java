package interfaces;

import aplicacao.*;
import dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FormularioEquipe {
    private JPanel painel;
    private JTextField insereCod;
    private JTextField insereQuant;
    private JTextField insereLatitude;
    private JTextField insereLongitude;
    private JLabel tituloPag;
    private JLabel codLabel;
    private JLabel quantLabel;
    private JLabel latLabel;
    private JLabel longLabel;
    private JTextArea campoTexto;
    private JButton okBotao;
    private JButton limparBotao;
    private JButton fecharBotao;
    private JButton dadosBotao;
    private JScrollPane scrollPane;

    public JPanel getPainel() {
        return painel;
    }

    private Equipes equipesArray = new Equipes();

    public FormularioEquipe(ACMEEquipe equipes) {

        //botão para confirmar o cadastramento
        okBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int quant = 0;
                    double lat = 0.0;
                    double longi = 0.0;
                    boolean cadastra = true;

                    if(e.getSource() == okBotao) {

                        String cod = insereCod.getText();
                        if(cod.isBlank()) throw new Error("Codinome vazio!");

                        try {
                            quant = Integer.parseInt(insereQuant.getText());
                            if(quant <= 0) throw new NumberFormatException("Quantidade negativa ou nula!");
                        } catch(NumberFormatException ex) {
                            campoTexto.append("\n" + "Quantidade inválida! Erro: " + ex.getMessage() + "\n");
                            cadastra = false;
                        }

                        try {
                            lat = Double.parseDouble(insereLatitude.getText());
                            if(lat < -90 || lat > 90) throw new NumberFormatException("Latitude inválida! Insira um valor entre -90 e 90!");
                        } catch(NumberFormatException ex) {
                            campoTexto.append("\n" + "Latitude inválida! Erro: " + ex.getMessage() + "\n");
                            cadastra = false;
                        }

                        try {
                            longi = Double.parseDouble(insereLongitude.getText());
                            if(longi < -180 || longi > 180) throw new NumberFormatException("Longitude inválida! Insira um valor entre -180 e 180!");
                        } catch(NumberFormatException ex) {
                            campoTexto.append("\n" + "Longitude inválida! Erro: " + ex.getMessage() + "\n");
                            cadastra = false;
                        }

                        if(cadastra) {
                            if (equipesArray.addEquipe(new Equipe(cod, quant, lat, longi))) {
                                campoTexto.append("Equipe cadastrada com sucesso!" + "\n" + equipesArray.getEquipes().get(equipesArray.getEquipes().size() - 1).toString() + "\n");
                                equipesArray.ordenaEquipes();
                            } else {
                                campoTexto.append("\n" + "Equipe já cadastrada!" + "\n");
                            }
                        }
                    }
                } catch (Error ex) {
                    campoTexto.append("\n" + "Erro: " + ex.getMessage() + "\n");
                }
            }
        });

        //mostra os dados cadastrados
        dadosBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == dadosBotao) {
                    if(equipesArray.getEquipes().isEmpty()) {
                        campoTexto.append("\n" + "Não há equipes cadastradas!" + "\n");
                    } else {
                        campoTexto.append("\n" + "Equipes cadastradas: " + "\n");
                        for(Equipe e1 : equipesArray.getEquipes()) {
                            campoTexto.append(e1.toString() + "\n");
                        }
                    }
                }
            }
        });

        //limpa todos os campos e a área de texto
        limparBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == limparBotao) {
                    campoTexto.setText("");
                    insereCod.setText("");
                    insereQuant.setText("");
                    insereLatitude.setText("");
                    insereLongitude.setText("");
                }
            }
        });

        //campo de texto
        campoTexto.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        //finaliza a aplicação
        fecharBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}

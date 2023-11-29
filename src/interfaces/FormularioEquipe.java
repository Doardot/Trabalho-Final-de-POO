package interfaces;

import aplicacao.*;
import dados.Equipe.*;

import javax.swing.*;
import java.awt.event.*;


public class FormularioEquipe extends JFrame implements ActionListener {

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

    private ACMEEquipe acmeEquipe;
    private ACMEAtendimento acmeAtendimento;

    public FormularioEquipe(ACMEEquipe equipes, ACMEAtendimento atendimento) {
        this.add(painel);
        this.acmeEquipe = equipes;
        this.acmeAtendimento = atendimento;
        this.setSize(1200, 800);
        this.dispose();
        this.setVisible(true);

        this.add(painel);
        painel.setVisible(true);
        this.setVisible(true);

        okBotao.addActionListener(this);
        dadosBotao.addActionListener(this);
        limparBotao.addActionListener(this);

        //campo de texto
        campoTexto.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });

        fecharBotao.addActionListener(this);

        this.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okBotao) {
            try {
                int quant = 0;
                double lat = 0.0;
                double longi = 0.0;
                boolean cadastra = true;

                String cod = insereCod.getText();
                if (cod.isBlank()) throw new Error("Codinome vazio!");

                try {
                    quant = Integer.parseInt(insereQuant.getText());
                    if (quant <= 0) throw new NumberFormatException("Quantidade negativa ou nula!");
                } catch (NumberFormatException ex) {
                    campoTexto.append("\n" + "Quantidade inválida! Erro: " + ex.getMessage() + "\n");
                    cadastra = false;
                }

                try {
                    lat = Double.parseDouble(insereLatitude.getText());
                    if (lat < -90 || lat > 90)
                        throw new NumberFormatException("Latitude inválida! Insira um valor entre -90 e 90!");
                } catch (NumberFormatException ex) {
                    campoTexto.append("\n" + "Latitude inválida! Erro: " + ex.getMessage() + "\n");
                    cadastra = false;
                }

                try {
                    longi = Double.parseDouble(insereLongitude.getText());
                    if (longi < -180 || longi > 180)
                        throw new NumberFormatException("Longitude inválida! Insira um valor entre -180 e 180!");
                } catch (NumberFormatException ex) {
                    campoTexto.append("\n" + "Longitude inválida! Erro: " + ex.getMessage() + "\n");
                    cadastra = false;
                }

                if (cadastra) {
                    Equipe equipe = new Equipe(cod, quant, lat, longi, null);
                    if (acmeEquipe.addEquipe(equipe)) {
                        campoTexto.append("Equipe cadastrada com sucesso!" + "\n" + acmeEquipe.getEquipes().get(acmeEquipe.getEquipes().size() - 1).toString() + "\n");
                        acmeAtendimento.alocaEquipe(acmeEquipe.getEquipes());
                    } else {
                        campoTexto.append("\n" + "Equipe já cadastrada!" + "\n");
                    }
                }

            } catch (Error ex) {
                campoTexto.append("\n" + "Erro: " + ex.getMessage() + "\n");
            }
        }

        if (e.getSource() == dadosBotao) {
            if (acmeEquipe.getEquipes().isEmpty()) {
                campoTexto.append("\n" + "Não há equipes cadastradas!" + "\n");
            } else {
                campoTexto.append("\n" + "Equipes cadastradas: " + "\n");
                for (Equipe e1 : acmeEquipe.getEquipes()) {
                    campoTexto.append(e1.toString() + "\n");
                }
            }
        }

        if (e.getSource() == limparBotao) {
            campoTexto.setText("");
            insereCod.setText("");
            insereQuant.setText("");
            insereLatitude.setText("");
            insereLongitude.setText("");
        }

        if (e.getSource() == fecharBotao) {
            this.dispose();
        }
    }
}
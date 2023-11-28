package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraDeArquivos extends JFrame implements ActionListener {

    private JPanel janela;
    private JButton button1;
    private JLabel dadosTexto;
    private JTextField textField1;
    private JLabel insiraTexto;

    public LeituraDeArquivos() {
        setContentPane(janela);
        this.setSize(450, 200);
        this.setVisible(true);
        button1.addActionListener(this);







    }



    public void leituraArquivo(String arquivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");


            }
        } catch (Exception e) {

            if(arquivo.contains(".null")) {
                new JanelaDeErro("Arquivo não encontrado");

            }
            arquivo.replace(".json", ".null");
            arquivo.replace(".txt", ".json");
            arquivo.replace(".csv", ".txt");

            leituraArquivo(arquivo);



        }


    }









    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1) {
            String arquivo = textField1.getText();
            arquivo += ".csv";
            leituraArquivo(arquivo);



        }

    }
}

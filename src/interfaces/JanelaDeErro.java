package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaDeErro extends JFrame implements ActionListener {
    private JTextPane campoDeErro;
    private JPanel painel;
    private JButton OKButton;

    public JanelaDeErro() {

        this.setSize(300,200);
        this.add(painel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}

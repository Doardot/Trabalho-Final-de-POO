package interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaDeErro extends JFrame implements ActionListener {
    private JLabel campoDeErro;
    private JPanel painel;
    private JButton OKButton;
    private JTextPane campoDeTexto;

    public JanelaDeErro(String erro) {

        OKButton.addActionListener(this);
        this.setSize(450,200);
        this.add(painel);
        this.setVisible(true);
        this.setResizable(false);
        campoDeTexto.setOpaque(false);
        campoDeTexto.setText(erro);

        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == OKButton) this.dispose();
    }
}

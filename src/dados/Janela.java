package dados;
import interfaces.*;

import javax.swing.*;
public class Janela extends JFrame {
    private FormularioEquipe form;
    public Janela() {
        super();
        form = new FormularioEquipe();
        this.add(form.getPainel());

        this.setTitle("Cadastro da equipe");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

package interfaces;

import aplicacao.ACMEAtendimento;
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import aplicacao.ACMEEvento;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VinculaEquipamento {

    private JLabel titulo;
    private JLabel labelEquipa;
    private JTextField insereEquipamento;
    private JLabel labelEquipe;
    private JTextField insereEquipe;
    private JTextArea textoVinc;
    private JButton confirmaButton;

    private ACMEEquipe ACMEequipe;
    private ACMEEvento ACMEevento;
    private ACMEAtendimento ACMEatendimento;
    private ACMEEquipamento ACMEequipamento;


    public VinculaEquipamento() {
        confirmaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipamentoSelecionado = insereEquipamento.getText();
                String equipeSelecionada = insereEquipe.getText();

                Equipamento equipamentoIN = null;
                for (Equipamento eq : ACMEequipamento.getLista()) {
                    if (eq.getNome().equalsIgnoreCase(equipamentoSelecionado)) {
                        equipamentoIN = eq;
                        /*
                        código de teste
                        textoVinc.append("equipamento: " + equipamentoIN.getNome());
                         */
                        break;
                    }
                }

                Equipe equipeIN = null;
                for (Equipe eq : ACMEequipe.getEquipes()) {
                    if (eq.getCodinome().equalsIgnoreCase(equipeSelecionada)) {
                        equipeIN = eq;
                        /*
                        código de teste
                        textoVinc.append("cod " + equipeIN.getCodinome());
                        */
                        break;
                    }
                }

                if (equipamentoIN != null && equipeIN != null) {
                    equipeIN.setEquipamento(equipamentoIN);
                    textoVinc.append("Equipamento: " + equipamentoSelecionado + " vinculado à equipe: " + equipeSelecionada + "\n");
                } else {
                    textoVinc.append("Equipamento ou equipe não encontrados\n");
                }
            }
        });
    }
}

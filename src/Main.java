
import aplicacao.ACMEEquipamento;
import aplicacao.ACMEEquipe;
import interfaces.JanelaPrincipal;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;

public class Main {

    private static ACMEEquipe ACMEequipe;
    private static ACMEEquipamento ACMEEquipamento;
    public static void main(String[] args) {

        new JanelaPrincipal();
        Equipe equipe = new Equipe("Equipe 1", 5, 10.0, 10.0, null);
        ACMEequipe.addEquipe(equipe);
        Equipamento equipamento = new Equipamento(1, "Caminhao", 100.0);
        ACMEEquipamento.adicionaCaminhao(1, "Caminhao", 100.0, 100.0);
    }
}

package aplicacao;

import dados.Equipe.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ACMEEquipe {
    private ArrayList<Equipe> equipeArray;

    public ACMEEquipe() {
        equipeArray = new ArrayList<>();

    }

    public ArrayList<Equipe> getEquipes() {
        return equipeArray;
    }

    public boolean addEquipe(Equipe equipe) {
        for (Equipe e : getEquipes()) {
            if (e.getCodinome().equals(equipe.getCodinome())) {
                return false;
            }
        }
        ordenaEquipes();
        return this.equipeArray.add(equipe);
    }

    //ordena as equipes em ordem alfabética
    public void ordenaEquipes() {
        equipeArray.sort(Comparator.comparing(Equipe::getCodinome));
    }

}

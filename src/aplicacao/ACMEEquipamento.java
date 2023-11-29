package aplicacao;
import java.util.ArrayList;
import java.util.Comparator;

import dados.Equipamento.*;

import dados.Equipamento.Equipamento;

public class ACMEEquipamento {

    private ArrayList<Equipamento> equipamento;


    public ACMEEquipamento() {
        equipamento = new ArrayList<>();

        //equipamento teste
        adicionaEquipamento(new CaminhaoTanque(1, "a", 1000, 1000));
    }
    public void organizaLista() {
        if(equipamento.size() == 0) {
            return;
        }
        else equipamento.sort(Comparator.comparingInt(Equipamento::getId));
    }

    public boolean adicionaEquipamento (Equipamento aux) throws NullPointerException {

        for (int i = 0; i < equipamento.size(); i++) {
            if (aux.getId() == equipamento.get(i).getId()) {
                throw new NullPointerException();
            }
        }
        equipamento.add(aux);
        organizaLista();
        return true;
    }


    public ArrayList<Equipamento> getLista() {
        return this.equipamento;
    }

}



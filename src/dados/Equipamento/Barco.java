package dados.Equipamento;

import dados.Equipamento.Equipamento;

public class Barco extends Equipamento {
    private int capacidade;

    public Barco(int id, String nome, double custoDia, int capacidade) {
        super(id, nome, custoDia);
        this.capacidade = capacidade;
    }



    @Override
    public String toString() {
        return super.toString() + ", Capacidade: " + capacidade+"\n";
    }
}

package dados.Equipamento;

import dados.Equipamento.Equipamento;

public class Barco extends Equipamento {
    private int capacidade;
    private int tipo;
    public Barco(int id, String nome, double custoDia, int capacidade) {
        super(id, nome, custoDia);
        this.capacidade = capacidade;
        this.tipo = 1;
    }



    @Override
    public String toString() {
        return super.toString() + ", Capacidade: " + capacidade+"\n";
    }


    public String toStringDados() {
    return super.toStringDados()+ ";"+tipo + ";"+capacidade+"\n";
    }
}
package Equipamentos;

public class Caminhao extends Equipamento{

    private double capacidade;

    public Caminhao(int id, String nome, double custoDia, double capacidade) {
        super(id, nome, custoDia);
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade: " + capacidade;
    }





}

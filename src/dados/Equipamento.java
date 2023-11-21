package Equipamentos;

public class Equipamento {
    private int id;
    private String nome;
    private double custoDia;

    public Equipamento(int id, String nome, double custoDia) {
        this.id = id;
        this.nome = nome;
        this.custoDia = custoDia;
    }


    public int getId() {
        return id;
    }


    public String toString() {
        return "Id: " +id +","+ " nome: " +  nome + ", Custo por dia: "+ custoDia;
    }
}

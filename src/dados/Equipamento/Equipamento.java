package dados.Equipamento;

import dados.Equipe.Equipe;

public class Equipamento {
    private int id;
    private String nome;
    private double custoDia;
    private Equipe equipe;


    public Equipamento(int id, String nome, double custoDia) {
        this.id = id;
        this.nome = nome;
        this.custoDia = custoDia;
        this.equipe = null;
    }
    public Equipamento(int id, String nome, double custoDia, String codinome) {
        this.id = id;
        this.nome = nome;
        this.custoDia = custoDia;

    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getCustoDia() {
        return custoDia;
    }

    public String toString() {
        return "Id: " + id + "," + " nome: " + nome + ", Custo por dia: " + custoDia;
    }

    public String toStringDados(){
        return id+";"+nome+";"+custoDia+";"+equipe.getCodinome()+"\n";
    }


}
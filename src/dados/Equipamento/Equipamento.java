package dados.Equipamento;
public class Equipamento {
    private int id;
    private String nome;
    private double custoDia;
    private String codinome;


    public Equipamento(int id, String nome, double custoDia) {
        this.id = id;
        this.nome = nome;
        this.custoDia = custoDia;
    }

    public void setCodinome(String codinome) {
        this.codinome = codinome;
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
        return id+";"+nome+";"+custoDia+";";
    }


}
<<<<<<< HEAD
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
=======
package dados;
import java.util.ArrayList;

public class Equipamento {
	private int id;
	private String nome;
	private double custoDia;
	private Equipe equipe;
	private ArrayList<Equipamento> equipamentos;
	private Atendimento atendimento;

	public Equipamento(int id, String nome, double custoDia) {
		this.id = id;
		this.nome = nome;
		this.custoDia = custoDia;
	}

	public double getCustoDia() {
		return custoDia;
	}
>>>>>>> 33aee825021287b567f95ec1807233b13569b2b6
}

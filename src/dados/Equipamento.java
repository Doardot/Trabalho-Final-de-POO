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
}

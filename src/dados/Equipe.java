package dados;

import java.util.ArrayList;
import java.util.Collection;

public class Equipe {
	private String codinome; // nome da equipe
	private int quantidade; // quantidade de membros
	private double latitude; // localização da equipe
	private double longitude;

	private ArrayList<Atendimento> atend;
	private ArrayList<Equipamento> equipamento;
	private Atendimento atendimento;
	private ArrayList<Equipamento> equipamentos;

	public Equipe(String codinome, int quantidade, double latitude, double longitude) {
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCodinome() { return codinome; }
	public int getQuantidade() { return quantidade; }

	public String toString() {
		return "Codinome: " + codinome + " Quantidade de membros: " + quantidade
				+ " Latitude: " + latitude + " Longitude: " + longitude;
	}

	public double custoEquipamento() {
		double custo = 0.0;
		for (Equipamento e : equipamentos) {
			custo += e.getCustoDia();
		}
		custo = custo * atendimento.getDuracao();
		return custo;
	}
}

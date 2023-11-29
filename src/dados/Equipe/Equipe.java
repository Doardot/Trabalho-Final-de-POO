package dados.Equipe;

import dados.Atendimento.Atendimento;
import dados.Equipamento.Equipamento;

import java.util.ArrayList;

public class Equipe {
	private String codinome; // nome da equipe
	private int quantidade; // quantidade de membros
	private double latitude; // localização da equipe
	private double longitude;
	private Equipamento equipamento;
	private ArrayList<Equipamento> equipamentos;
	private Equipe equipe;
	private Atendimento atendimento;

	public Equipe(String codinome, int quantidade, double latitude, double longitude, Equipamento equipamento){
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.equipamento = equipamento;
	}

	public String getCodinome() { return codinome; }
	public int getQuantidade() { return quantidade; }

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public ArrayList<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public String toString() {
		return "Codinome: " + codinome + " Quantidade de membros: " + quantidade
				+ " Latitude: " + latitude + " Longitude: " + longitude;
	}

	public double getDistancia() {
		return Math.sqrt(Math.pow(latitude, 2) + Math.pow(longitude, 2));
	}

	public double custoEquipamento() {
		double custo = 0.0;

		//somatorio custo diario equipamentos
		for (Equipamento e : equipe.getEquipamentos()) {
			custo += e.getCustoDia();
		}

		//multiplicacao com a duracao
		custo = custo * atendimento.getDuracao();

		return custo;
	}

	public Double calculaCustoDeslocamento(){
		double custo = 0.0;
		double custoEquip = 0.0;

		//somatorio custo diario equipamentos
		for (Equipamento e : equipe.getEquipamentos()) {
			custoEquip += e.getCustoDia();
		}

		custo += (getDistancia() * (100 * quantidade + 0.1 * custoEquip));
		return custo;
	}

}

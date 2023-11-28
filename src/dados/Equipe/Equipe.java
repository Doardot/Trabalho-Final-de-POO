package dados.Equipe;

import dados.Equipamento.Equipamento;

import java.util.ArrayList;

public class Equipe {
	private String codinome; // nome da equipe
	private int quantidade; // quantidade de membros
	private double latitude; // localização da equipe
	private double longitude;
	private Equipamento equipamento;
	private ArrayList<Equipamento> equipamentos;

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

}

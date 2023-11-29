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
	private boolean	estaAlocada;

	public Equipe(String codinome, int quantidade, double latitude, double longitude, Equipamento equipamento){
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
		this.equipamento = equipamento;
		estaAlocada = false;
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
	public boolean getEstaAlocada() { return estaAlocada; }
	public void setEstaAlocada(boolean flag) { estaAlocada = flag; }
	public String toString() {
		return "Codinome: " + codinome + " Quantidade de membros: " + quantidade
				+ " Latitude: " + latitude + " Longitude: " + longitude+"\n";
	}
	public void setAtendimento(Atendimento a) {
		atendimento = a;
	}
	public Atendimento getAtendimento() {
		return atendimento;
	}

	public double getDistancia() {
		double distancia = 0.0;
		double lat1 = Math.toRadians(latitude);
		double lat2 = Math.toRadians(atendimento.getEvento().getLatitude());
		double long1 = Math.toRadians(longitude);
		double long2 = Math.toRadians(atendimento.getEvento().getLongitude());

		double dlon = (long2 - long1);
		double dlat = (lat2 - lat1);

		double a = Math.pow(Math.sin(dlat / 2), 2)
				+ Math.cos(lat1) * Math.cos(lat2)
				* Math.pow(Math.sin(dlon / 2),2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double r = 6371;

		distancia = c * r;

		return distancia;
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

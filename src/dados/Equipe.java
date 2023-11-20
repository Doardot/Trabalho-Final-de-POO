package dados;

import java.util.ArrayList;
import java.util.Collection;

public class Equipe {

	private String codinome;

	private int quantidade;

	private double latitude;

	private double longitude;

	private ArrayList<Atendimento> atendimento;

	private ArrayList<Equipamento> equipamento;

	public Equipe(String codinome, int quantidade, double latitude, double longitude) {
		this.codinome = codinome;
		this.quantidade = quantidade;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}

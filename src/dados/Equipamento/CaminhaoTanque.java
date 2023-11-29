package dados.Equipamento;

import dados.Equipamento.Equipamento;

public class CaminhaoTanque extends Equipamento {

	private double capacidade;
	private int tipo;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
		this.tipo = 2;
	}

	@Override
	public String toString() {
		return super.toString() + ", Capacidade: " + capacidade + "\n";
	}

	public String toStringDados() {
		return super.toStringDados()+ ";"+tipo + ";" + capacidade + "\n";
	}
}
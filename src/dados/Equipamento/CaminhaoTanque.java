package dados.Equipamento;

import dados.Equipamento.Equipamento;

public class CaminhaoTanque extends Equipamento {

	private double capacidade;

	public CaminhaoTanque(int id, String nome, double custoDia, double capacidade) {
		super(id, nome, custoDia);
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		return super.toString() + ", Capacidade: " + capacidade+"\n";
	}
}

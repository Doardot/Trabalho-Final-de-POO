package dados.Atendimento;

import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

public class Atendimento {
	private int cod;
	private String dataInicio;
	private int duracao;
	private String status;
	private Equipe equipe;
	private Evento evento;
	private AtendimentoStatus atendimentoStatus;

	public Atendimento(int cod, String dataInicio, int duracao, String status, Equipe equipe, Evento evento, AtendimentoStatus atendimentoStatus) {
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.status = status;
		this.equipe = equipe;
		this.evento = evento;
		this.atendimentoStatus = atendimentoStatus;
	}

	public int getDuracao() { return duracao; }

	public double calculaCusto() {
		double custo = 0.0;
		return custo;
	}

	public double custoAtendimento(){
		return (custoEquipe() + custoEquipamento() + custoDeslocamento());
	}

	public double custoEquipe(){
		return (equipe.getQuantidade() * 250 * getDuracao());
	}

	public double custoEquipamento() {
		double custo = 0.0;
		for (Equipamento e : equipe.getEquipamentos()) {
			custo += e.getCustoDia();
		}
		custo = custo * duracao;
		return custo;
	}
	public Double custoDeslocamento(){
		double custo = 0.0;
		return custo;
	}

}

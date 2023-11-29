package dados.Atendimento;

import aplicacao.ACMEEquipe;
import dados.Equipamento.Equipamento;
import dados.Equipe.Equipe;
import dados.Evento.Evento;

public class Atendimento {
	private int cod;
	private String dataInicio;
	private int duracao;
	private Equipe equipe;
	private Evento evento;
	private AtendimentoStatus atendimentoStatus;

	public Atendimento(int cod, String dataInicio, int duracao, Equipe equipe, Evento evento, AtendimentoStatus atendimentoStatus) {
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.equipe = equipe;
		this.evento = evento;
		this.atendimentoStatus = atendimentoStatus;
	}

	public int getCod() {
		return cod;
	}
	public int getDuracao() {
		return duracao;
	}

	public double calculaCusto() {
		double custo = 0.0;
		return custo;
	}

	public double custoAtendimento(){
		return (custoEquipe() + equipe.custoEquipamento() + equipe.calculaCustoDeslocamento());
	}

	public double custoEquipe(){
		return (equipe.getQuantidade() * 250 * getDuracao());
	}

	public Double custoDeslocamento(){
		double custo = 0.0;
		return custo;
	}

}

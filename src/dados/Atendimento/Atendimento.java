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
	private String codigo;

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
	public Equipe getEquipe() { return equipe; }
	public Evento getEvento() { return evento; }
	public AtendimentoStatus getStatus() { return atendimentoStatus; }
	public void setStatus(AtendimentoStatus atendimentoStatus) { this.atendimentoStatus = atendimentoStatus; }
	public void setEquipe(Equipe equipe) { this.equipe = equipe; }
	public void setEvento(Evento evento) {
		this.evento = evento;
		this.codigo = evento.getCodigo();
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double custoAtendimento(){
		return (custoEquipe() + equipe.custoEquipamento() + equipe.calculaCustoDeslocamento());
	}

	public double custoEquipe(){
		return (equipe.getQuantidade() * 250 * getDuracao());
	}

	public Double custoDeslocamento() {
		double custo = 0.0;
		return custo;
	}

	public String toString() {
		//implementar toString
		return "Código: " + cod + ", Data de Início: " + dataInicio + ", Duração: " + duracao + ", Equipe: " + equipe +
				", Evento: " + evento + ", Status: " + atendimentoStatus;

	}
	public String toStringDados() {
		return cod+";"+dataInicio+";"+duracao+";"+atendimentoStatus.getStatus()+";"+codigo+"\n";
	}


}

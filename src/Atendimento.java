public class Atendimento {

	private int cod;

	private String dataInicio;

	private int duracao;

	private String status;

	private Equipe equipe;

	private Evento evento;

	public Atendimento(int cod, String dataInicio, int duracao, String status) {
		this.cod = cod;
		this.dataInicio = dataInicio;
		this.duracao = duracao;
		this.status = status;
	}

	public double calculaCusto() {
		return 0;
	}

}

package dados;

public class Ciclone extends Evento {

	private double velocidade;

	private double precipitacao;

	public Ciclone(String codigo, String data, double latitude, double longitude, double velocidade, double precipitacao, Atendimento atendimento) {
		super(codigo, data, latitude, longitude, atendimento);
		this.velocidade = velocidade;
		this.precipitacao = precipitacao;
	}

	



}
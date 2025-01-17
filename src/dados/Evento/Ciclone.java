package dados.Evento;

public class Ciclone extends Evento {

	private double velocidade;

	private double precipitacao;
	private int tipo;

	public Ciclone(String codigo, String data, double latitude, double longitude, double velocidade, double precipitacao) {
		super(codigo, data, latitude, longitude);
		this.velocidade = velocidade;
		this.precipitacao = precipitacao;
		this.tipo = 1;
	}

	@Override
	public String toString() {
		return "Ciclone (" + super.toString() + ", velociadde: " + velocidade + ", precipitação: " + precipitacao + ");";
	}

	public String toStringDados() {
		return super.toStringDados()+";"+tipo+";"+velocidade+";"+precipitacao+"\n";
	}
}

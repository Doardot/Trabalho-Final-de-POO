package dados.Evento;

public class Seca extends Evento {

	private int estiagem;
	private int tipo;

	public Seca(String codigo, String data, double latitude, double longitude, int estiagem) {
		super(codigo, data, latitude, longitude);
		this.estiagem = estiagem;
		this.tipo = 3;
	}

	@Override
	public String toString() {
		return "Seca (" + super.toString() + ", estiagem: " + estiagem + ");";
	}

	public String toStringDados() {
		return super.toStringDados()+";"+tipo+";"+estiagem+"\n";
	}
}

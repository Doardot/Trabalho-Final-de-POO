package dados.Evento;

public class Terremoto extends Evento {

	private double magnitude;
	private int tipo;

	public Terremoto(String codigo, String data, double latitude, double longitude, double magnitude) {
		super(codigo, data, latitude, longitude);
		this.magnitude = magnitude;
		this.tipo = 2;
	}

	@Override
	public String toString() {
		return "Ciclone (" + super.toString() + ", magnetude: " + magnitude + ");";
	}

	public String toStringDados() {
		return super.toStringDados()+";"+tipo+";"+magnitude+"\n";
	}


}

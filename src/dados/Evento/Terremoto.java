package dados.Evento;

public class Terremoto extends Evento {

	private double magnitude;

	public Terremoto(String codigo, String data, double latitude, double longitude, double magnitude) {
		super(codigo, data, latitude, longitude);
		this.magnitude = magnitude;
	}

	@Override
	public String toString() {
		return "Terremoto (" + super.toString() + ", magnetude: " + magnitude + ");";
	}
}

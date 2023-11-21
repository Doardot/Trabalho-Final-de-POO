package dados;

public class Terremoto extends Evento {

	private double magnitude;

	public Terremoto(String codigo, String data, double latitude, double longitude, Atendimento atendimento,
			double magnitude) {
		super(codigo, data, latitude, longitude, atendimento);
		this.magnitude = magnitude;
	}

	@Override
	public String toString() {
		return "Ciclone (" + super.toString() + ", magnetude: " + magnitude + ");";
	}
}

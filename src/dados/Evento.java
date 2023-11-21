package dados;

public class Evento {

	private String codigo;

	private String data;

	private double latitude;

	private double longitude;

	private Atendimento atendimento;

	public Evento(String codigo, String data, double latitude, double longitude, Atendimento atendimento) {
		this.codigo = codigo;
		this.data = data;
		this.latitude = latitude;
		this.longitude = longitude;
		this.atendimento = atendimento;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo +  ", data: " + data + ", latitude: " + latitude +  ", longitude: " + longitude;
	}

	public String getCodigo() {
		return codigo;
	}
}

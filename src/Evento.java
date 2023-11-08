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

	
}

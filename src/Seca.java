public class Seca extends Evento {

	private int estiagem;

	public Seca(String codigo, String data, double latitude, double longitude, Atendimento atendimento, int estiagem) {
		super(codigo, data, latitude, longitude, atendimento);
		this.estiagem = estiagem;
	}

	
}

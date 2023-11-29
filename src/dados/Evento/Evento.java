package dados.Evento;

public class Evento {
	private String codigo;
	private String data;
	private double latitude;
	private double longitude;
	private boolean estaDisponivel;

	public Evento(String codigo, String data, double latitude, double longitude) {
		this.codigo = codigo;
		this.data = data;
		this.latitude = latitude;
		this.longitude = longitude;
		estaDisponivel = true;
	}

	@Override
	public String toString() {
		return "codigo: " + codigo +  ", data: " + data + ", latitude: " + latitude +  ", longitude: " + longitude;
	}

	public String getCodigo() {
		return codigo;
	}
	public double getLatitude() { return latitude; }
	public double getLongitude() { return longitude; }
	public boolean getEstaDisponivel() {
		return estaDisponivel;
	}
	public void setEstaDisponivel(boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}
}

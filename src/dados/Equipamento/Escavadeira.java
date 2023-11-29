package dados.Equipamento;


public class Escavadeira extends Equipamento {

   private String combustivel;
   private double carga;
    private int tipo;

    public Escavadeira(int id, String nome, double custoDia, String combustivel, double carga) {
        super(id, nome, custoDia);
        this.combustivel = combustivel;
        this.carga = carga;
        this.tipo = 3;
    }




    @Override
    public String toString() {
        return super.toString() + ", Combustivel: "+ combustivel+ ", Carga: "+carga+"\n";


    }

    public String toStringDados() {
        return super.toStringDados()+ ";"+ tipo + ";"+combustivel+";"+carga+"\n";
    }





}

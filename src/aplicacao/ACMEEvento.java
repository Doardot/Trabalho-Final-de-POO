package aplicacao;

import dados.Evento.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ACMEEvento {
    private ArrayList<Evento> eventos;
    public ACMEEvento() {
        eventos = new ArrayList<>();

        //evento de teste
        cadastraEvento(new Ciclone("a", "a", 10, 20, 20, 20));
    }

    public boolean cadastraEvento(Evento evento) {
        for (int i = 0; i < eventos.size(); i++) {
            if (eventos.get(i).getCodigo() .equals(evento.getCodigo())) {
                return false;
            }
        }
        eventos.add(evento);
        ordenaEvento();
        return true;
    }

    private void ordenaEvento() {
        eventos.sort(Comparator.comparing(Evento::getCodigo));
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
}

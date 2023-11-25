package aplicacao;

import dados.Equipe.Equipe;
import dados.Evento.Evento;

import java.util.ArrayList;
import java.util.Comparator;

public class ACMEEvento {
    private ArrayList<Evento> eventos;
    public ACMEEvento() {
        eventos = new ArrayList<>();
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

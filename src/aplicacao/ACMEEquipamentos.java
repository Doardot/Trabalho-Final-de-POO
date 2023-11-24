import Equipamentos.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;

public class ACMEEquipamentos {

    private JanelaDeEventos janela;
    private ArrayList<Equipamento> equipamento;

    public ACMEEquipamentos() {

        equipamento = new ArrayList<>();
    }


    public void organizaLista() {
        if(equipamento.size() == 0) {
            return;
        }
        else equipamento.sort(Comparator.comparingInt(Equipamento::getId));

    }


        public boolean adicionaCaminhao (int id, String nome,double custoDia, double capacidade) throws NullPointerException {

                Caminhao aux = new Caminhao(id, nome, custoDia, capacidade);

                for (int i = 0; i < equipamento.size(); i++) {
                    if (aux.getId() == equipamento.get(i).getId()) {
                        throw new NullPointerException();
                    }
                }
                equipamento.add(aux);
                return true;
            }


        public boolean adicionaBarco (int id, String nome,double custoDia, int capacidade) throws NullPointerException {

            Barco aux = new Barco(id, nome, custoDia, capacidade);

            for (int i = 0; i < equipamento.size(); i++) {
                if (aux.getId() == equipamento.get(i).getId()) {
                    throw new NullPointerException();
                }
            }
            equipamento.add(aux);
            return true;

        }

        public boolean adicionaEscavadeira ( int id, String nome,double custoDia, String combustivel,double carga) throws NullPointerException {
            Escavadeira aux = new Escavadeira(id, nome, custoDia, combustivel, carga);

            for (int i = 0; i < equipamento.size(); i++) {
                if (aux.getId() == equipamento.get(i).getId()) {
                    throw new NullPointerException();
                }
            }
            equipamento.add(aux);
            return true;

        }

        public ArrayList<Equipamento> getLista() {
            return this.equipamento;
        }

    }



















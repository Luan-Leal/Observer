package org.example;

import java.util.Observable;

public class Plataforma extends Observable {
    private String plataformaLogada;
    private String ultimaVezLogadoNoSistema;

    public Plataforma(String plataformaLogada, String ultimaVezLogadoNoSistema) {

        this.plataformaLogada = plataformaLogada;
        this.ultimaVezLogadoNoSistema = ultimaVezLogadoNoSistema;
    }

    public void lancarNotas() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "{" +
                " O usuário foi visto pela ultima vez na: '" + plataformaLogada + '\'' +
                ", O usuário logou no sistema à '" + ultimaVezLogadoNoSistema + '\'' +
                '}';
    }
}

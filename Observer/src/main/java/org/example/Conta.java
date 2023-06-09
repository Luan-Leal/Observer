package org.example;

import java.util.Observable;
import java.util.Observer;

public class Conta implements Observer {

    private String nome;
    private String ultimaApariçãoOnline;

    public Conta(String nome) {
        this.nome = nome;
    }

    public String getUltimaApariçãoOnline() {
        return this.ultimaApariçãoOnline;
    }

    public void cadastrar(Plataforma plataforma) {
        plataforma.addObserver(this);
    }

    public void update(Observable plataforma, Object arg1) {
        this.ultimaApariçãoOnline = this.nome + ", entrou na plataforma " + plataforma.toString();
    }
}

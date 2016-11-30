package com.example.jonathalima.jogodavelha;

import java.io.Serializable;

/**
 * Created by jonathalima on 29/11/16.
 */
public class Jogador implements Serializable{
    private String nome;
    private int numeroJogosGanhos;
    private boolean vezJogar;
    private String simboloJogada;

    public Jogador() {
        nome = null;
        numeroJogosGanhos = 0;
        vezJogar = false;
        simboloJogada = null;
    }

    public Jogador(String nome) {
        this.nome = nome;
        numeroJogosGanhos = 0;
        vezJogar = false;
        simboloJogada = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroJogosGanhos() {
        return numeroJogosGanhos;
    }

    public void setNumeroJogosGanhos(int numeroJogosGanhos) {
        this.numeroJogosGanhos = numeroJogosGanhos;
    }

    public boolean isVezJogar() {
        return vezJogar;
    }

    public void setVezJogar(boolean vezJogar) {
        this.vezJogar = vezJogar;
    }

    public String getSimboloJogada() {
        return simboloJogada;
    }

    public void setSimboloJogada(String simboloJogada) {
        this.simboloJogada = simboloJogada;
    }
}

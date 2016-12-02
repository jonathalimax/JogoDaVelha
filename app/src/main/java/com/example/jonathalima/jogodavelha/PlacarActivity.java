package com.example.jonathalima.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlacarActivity extends AppCompatActivity {

    private Intent intent;
    private Jogador jogador1, jogador2;
    private TextView nomeJogador1, nomeJogador2,
            vitoriasJogador1, vitoriasJogador2,
            valorVitoriaJogador1, valorVitoriaJogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placar);

        nomeJogador1 = (TextView) findViewById(R.id.nomeJogador1);
        nomeJogador2 = (TextView) findViewById(R.id.nomeJogador2);
        vitoriasJogador1 = (TextView) findViewById(R.id.placarJogador1);
        vitoriasJogador2 = (TextView) findViewById(R.id.placarJogador2);
        valorVitoriaJogador1 = (TextView) findViewById(R.id.placarEspecificoJogador1);
        valorVitoriaJogador2 = (TextView) findViewById(R.id.placarEspecificoJogador2);

        intent = getIntent();

        jogador1 = (Jogador) intent.getSerializableExtra("jogador1");
        jogador2 = (Jogador) intent.getSerializableExtra("jogador2");


        nomeJogador1.setText(jogador1.getNome());
        nomeJogador2.setText(jogador2.getNome());
        vitoriasJogador1.setText(String.valueOf(jogador1.getNumeroJogosGanhos()));
        vitoriasJogador2.setText(String.valueOf(jogador2.getNumeroJogosGanhos()));
        valorVitoriaJogador1.setText(vitoriasJogador1.getText() + " Vitórias");
        valorVitoriaJogador2.setText(vitoriasJogador2.getText() + " Vitórias");
    }

    public void voltar(View view) {
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("jogador1", jogador1);
        intent.putExtra("jogador2", jogador2);
        startActivity(intent);
    }
}

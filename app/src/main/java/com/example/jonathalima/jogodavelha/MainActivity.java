package com.example.jonathalima.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private String nomeGanhador;
    private View view;
    private TextView square, statusJogo;
    private Toast toast;
    private int[][] finalState;
    private Jogador jogador1, jogador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setView(getLayoutInflater().inflate(R.layout.activity_main, null));
        setContentView(getView());

        statusJogo = (TextView) findViewById(R.id.statusJogo);

        intent = getIntent();

        jogador1 = (Jogador) intent.getSerializableExtra("jogador1");
        jogador2 = (Jogador) intent.getSerializableExtra("jogador2");

        jogador1.setVezJogar(true);
        statusJogo.setText(jogador1.getNome() + " jogue!");

        finalState = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
                {1, 5, 9},
                {3, 5, 7}
        };
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void onClick(View v) {

        if (jogador1.isVezJogar()) {
            ((TextView) v).setText("X");
            jogador1.setVezJogar(false);
            jogador2.setVezJogar(true);

            if (jogador1.getSimboloJogada() == null) {
                jogador1.setSimboloJogada("X");
            }
        } else {
            ((TextView) v).setText("O");
            jogador1.setVezJogar(true);
            jogador2.setVezJogar(false);

            if (jogador2.getSimboloJogada() == null) {
                jogador2.setSimboloJogada("O");
            }
        }

        if (isEnd()) {
            intent = new Intent(getApplicationContext(), PlacarActivity.class);
            intent.putExtra("jogador1", jogador1);
            intent.putExtra("jogador2", jogador2);
            startActivity(intent);
        }
        ;

    }

    public void playAgain(View view) {

        for (int i = 1; i <= 9; i++) {
            square = getSquare(i);
            square.setText("");
        }

        jogador1.setSimboloJogada("");
        jogador2.setSimboloJogada("");

        setStatusVezJogar();

    }

    public TextView getSquare(int number) {
        return (TextView) getView().findViewWithTag("square" + number);
    }

    public boolean isEnd() {
        String s1 = null, s2, s3;
        boolean retorno = false;

        for (int i = 0; i <= 7; ++i) {
            s1 = getSquare(finalState[i][0]).getText().toString();
            s2 = getSquare(finalState[i][1]).getText().toString();
            s3 = getSquare(finalState[i][2]).getText().toString();

            if (!(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())) {

                if (s1.equals(s2) && s2.equals(s3)) {
                    retorno = true;

                    if (s1.equals(jogador1.getSimboloJogada())) {
                        jogador1.setNumeroJogosGanhos(jogador1.getNumeroJogosGanhos() + 1);
                        nomeGanhador = jogador1.getNome();
                    } else {
                        jogador2.setNumeroJogosGanhos(jogador2.getNumeroJogosGanhos() + 1);
                        nomeGanhador = jogador2.getNome();
                    }

                    toast = Toast.makeText(getView().getContext(), nomeGanhador + " ganhou!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    setStatusVezJogar();
                }
            }
        }
        return retorno;
    }

    public void setStatusVezJogar() {
        if (jogador1.isVezJogar()) {
            statusJogo.setText(jogador1.getNome() + " jogue!");
        } else {
            statusJogo.setText(jogador2.getNome() + " jogue!");
        }
    }
}

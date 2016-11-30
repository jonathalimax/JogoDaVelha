package com.example.jonathalima.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    private Jogador jogador1, jogador2;
    private EditText edtJogador1, edtJogador2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edtJogador1 = (EditText) findViewById(R.id.edtJogador1);
        edtJogador2 = (EditText) findViewById(R.id.edtJogador2);
    }

    public void jogar(View v){
        jogador1 = new Jogador(edtJogador1.getText().toString());
        jogador2 = new Jogador(edtJogador2.getText().toString());

        intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("jogador1", jogador1);
        intent.putExtra("jogador2", jogador2);

        startActivity(intent);
    }
}

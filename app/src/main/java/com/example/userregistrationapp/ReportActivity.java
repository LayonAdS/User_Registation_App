package com.example.userregistrationapp;
//importação de componentes de ui intençoes e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {
    // campo onde os dados do banco serao mostrados
    private TextView textViewReport;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        //Define o alyout XML dessa tela de relatorio
        setContentView(R.layout.activity_report);
        //mapeamento do textView do xml para o java
        textViewReport = findViewById(R.id.textViewReport);
        //Encontra o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //o botão de retorno utilizando expressão lamdda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());
    }

    //Metodo responsavel pela navegação entre as telas de app
    public void voltarParaCadastro()
    {
        //intençõa para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this,MainActivity.class);
        startActivity(intent);
        finish(); // fecha a tela de relatorio para não acomular na pilha de tarefas

    }
}

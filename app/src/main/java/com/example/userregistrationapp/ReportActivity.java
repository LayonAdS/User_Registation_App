package com.example.userregistrationapp;
//importação de componentes de ui intençoes e a biblioteca ROOM
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import  androidx.room.Room;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

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
        /* conexao com o bando de dados
          1- cria uma instancia do banco 'user-database'
          2- allowMainThreadQuieres():Serve para liberar operações de consultas feitas em thread da UI
          Por padrão, ROMM proibe isoo. o correto seria fazer consultas em threads seperadas
         */
        UserDatabase db = Room.databaseBuilder(getApplicationContext(),UserDatabase.class, "user-database").allowMainThreadQueris().build();
        // obtem o objeto dao(data access object) que contem as queries SQL
        UserDao userDao = db.userDao();
        // Recupera todos os dados salvos no bd e armazena numa lista
        List<User> userList = userDao.getALLUsers();
        //sTRINGbUILDER FORMA EFICIENTE DE CONTRUIR UMA sTRING LONGA DENTRO DE U7M LAÇO DE REPETIÇÃO
        StringBuilder report = new StringBuilder();

        // loop "for-wach" para percorrer cada objeto User dentro da lista reparada
        for(User user: userList)
        {
            report.append("Nome> ").append(user.getName()).append("\n").append("CPF: ").append(user.getCPF()).append("\n\n");
        }
        // Exibe o relatorio final montado na TextView da tela
        textViewReport.setText(report.toString());
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

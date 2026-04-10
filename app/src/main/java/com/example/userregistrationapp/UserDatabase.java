package com.example.userregistrationapp;

// importa as anotações e classes da biblioteca RQOM e do android
import android.content.Context; //classe que representa o contexto da aplicação(necessario para acessar recursos)

import androidx.room.Database; // anotações para marcar a classe como um banco de dados Romm
import androidx.room.Room;
import androidx.room.RoomDatabase;// classe base que representa o BD
/*
Anotação @database define que a classe representa o banco dados Romm
 ela especifica as entidades(tabelas) que o banco ira conter e a versão do BD
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    // intancia unica(singleton) do BD
    private static UserDatabase instance;
    //metodo abstrado que sera implementado pela Room
    //serve para acessar as operações do BD definidas na UserDao
    public abstract UserDao userDao();

    // metodo que retorna a instancia do BD
    // o uso do "synchronized" garante que apenas uma thread possa acessar este metodo por vez, evitando que duas instâncias do BD sejam criadas acidentalmente
    public static synchronized UserDatabase getInstance(Context context){
        // verificar se ja existe um instancia de BD criada
        //usa o contexto da aplicação para evitar vazamento de memoria
        //fallbacktoDestructiveMigration se houver mudança de versão e não houver migração o BD será recriado do zero
        if(instance == null){
            //cria a intancia do BD usando Room
            instance= Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        // retorna a instancia criada
        return instance;
    }
}

package com.mferreira.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {  //dentro da classe temos acesso a todos os recursos herdados do AppCompat

    @Override //significa que estamos sobreescrevendo um método
    protected void onCreate(Bundle savedInstanceState) {   //sobrescrevendo o método onCreate - responsavel por contruir nosssa interface
        super.onCreate(savedInstanceState);  //executando implementação padrão de onCreate da classe pai AppCompat
        setContentView(R.layout.activity_main); //método de configuração de interfce
    }

    public void selecionarPedra(View view){
        //usar o parametro view sempre que definir um metodo no onClick
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){  //nao tera retorno (void)

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int n = new Random().nextInt(3); // 0,1,2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes [n];

        switch (opcaoApp){
            case "pedra" : imagemResultado.setImageResource(R.drawable.pedra);  //recebe uma nova imagem a partir de um recurso
                break;
            case "papel" : imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" : imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
            (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
            (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
            (opcaoApp == "pedra" && opcaoSelecionada == "tesoura" )
        ){ //app ganhador, testar todas as possibilidades
            textoResultado.setText("Você perdeu :( ");
        }else if(
                (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura" )
        ) { //usuario ganhador, testar todas as possibilidades
            textoResultado.setText("Você ganhou :) ");
        }else{ //empate
            textoResultado.setText("Empatamos ;) ");
        }

        System.out.println("item clicado: " + opcaoApp);
    }
}
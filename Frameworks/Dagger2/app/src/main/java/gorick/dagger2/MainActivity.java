package gorick.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import gorick.dagger2.Dagger2.Module.MeuPrimeiroModule;
import gorick.dagger2.Dagger2.Module.MeuSegundoModule;

public class MainActivity extends AppCompatActivity {

    MeuPrimeiroModule meuPrimeiroModule;

    MeuSegundoModule meuSegundoModule;

    @Inject
    nome;


    TextView nome, nomeCompleto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (TextView) findViewById(R.id.nome);
        nomeCompleto = (TextView) findViewById(R.id.nomeCompleto);
        setNome(nome, nomeCompleto);

        Dagger2MeuPrimeiroComponent.inject(this);
        Dagger2MeuSegundoComponent.inject(this);
        Dagger2ApplicationComponent.inject(this);


    }

    public void setNome(TextView nome, TextView nomeCompleto){
        nome.setText(meuPrimeiroModule.toString());
        nomeCompleto.setText(meuSegundoModule.toString());
    }

}

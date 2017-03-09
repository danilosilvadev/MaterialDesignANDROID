package gorick.dagger2.Dagger2.Module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = MeuPrimeiroModule.class)
public class MeuSegundoModule {

    Application application;

    public MeuSegundoModule(Application application){
        this.application = application;
    }


    @Singleton
    @Provides
    public String nomeCompleto(MeuPrimeiroModule meuPrimeiroModule) {
        return new String(meuPrimeiroModule + " Silva");
    }

}

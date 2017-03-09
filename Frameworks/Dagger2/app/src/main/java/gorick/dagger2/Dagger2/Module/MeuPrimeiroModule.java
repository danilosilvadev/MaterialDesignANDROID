package gorick.dagger2.Dagger2.Module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sg-0036936 on 02/03/2017.
 */

@Module
public class MeuPrimeiroModule {

    Application application;

    @Singleton
    public MeuPrimeiroModule(Application application){
        this.application = application;
    }

    @Singleton
    @Provides
    public String nome() {
        return new String("Gorick");
    }

}

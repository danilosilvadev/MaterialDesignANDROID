package gorick.dagger2.Dagger2.Component;

import javax.inject.Singleton;

import dagger.Component;
import gorick.dagger2.MainActivity;

/**
 * Created by sg-0036936 on 02/03/2017.
 */

@Singleton
@Component(modules={MeuSegundoComponent.class})
public interface MeuSegundoComponent extends MeuPrimeiroComponent {

    void inject(MainActivity mainActivity);
}

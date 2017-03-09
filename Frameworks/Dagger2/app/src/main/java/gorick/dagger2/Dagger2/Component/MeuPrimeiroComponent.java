package gorick.dagger2.Dagger2.Component;

import dagger.Component;
import gorick.dagger2.Dagger2.Module.MeuPrimeiroModule;
import gorick.dagger2.Dagger2.Scope.PerInstance;
import gorick.dagger2.MainActivity;

/**
 * Created by sg-0036936 on 02/03/2017.
 */

@PerInstance
@Component(modules={MeuPrimeiroModule.class})
public interface MeuPrimeiroComponent {
    void inject(MainActivity mainActivity);
}

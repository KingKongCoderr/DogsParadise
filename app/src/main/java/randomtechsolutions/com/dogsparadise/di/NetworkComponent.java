package randomtechsolutions.com.dogsparadise.di;

import dagger.Component;
import randomtechsolutions.com.dogsparadise.BreedsFragment;

/**
 * Created by 112916 on 11/19/17.
 */

@Component(modules = NetworkModule.class)
public interface NetworkComponent {

	void inject(BreedsFragment breedsFragment);
}

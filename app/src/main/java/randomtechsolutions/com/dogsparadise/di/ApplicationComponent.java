package randomtechsolutions.com.dogsparadise.di;

import dagger.Component;
import randomtechsolutions.com.dogsparadise.BottomNavigationActivity;
import randomtechsolutions.com.dogsparadise.BreedsFragment;
import randomtechsolutions.com.dogsparadise.ImagesFragment;

/**
 * Created by 112916 on 11/19/17.
 */

@Component(modules = {NetworkModule.class,RoomModule.class})
public interface ApplicationComponent {

	void inject(BreedsFragment breedsFragment);

	void inject(ImagesFragment imagesFragment);
}

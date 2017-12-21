package randomtechsolutions.com.dogsparadise.di;

import android.app.Application;

/**
 * Created by 112916 on 11/19/17.
 */

public class DogsParadise extends Application {

	private static ApplicationComponent applicationComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		/*in the below dagger object graph i am not including .networkModule(new NetworkModule())
		as it hase implicit default constructor and doesn't require external state to be passed in as parameter
		and dagger can handle these kind of modules*/

		//also eliminating ".builder().build();" as the NetworkModule is implicitly created.

		applicationComponent = DaggerApplicationComponent.builder()
				.networkModule(new NetworkModule())
				.roomModule(new RoomModule(this)).build();

	}

	public static ApplicationComponent getApplicationComponent() {
		return applicationComponent;
	}
}

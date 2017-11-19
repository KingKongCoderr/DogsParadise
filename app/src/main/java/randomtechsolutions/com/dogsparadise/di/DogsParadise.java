package randomtechsolutions.com.dogsparadise.di;

import android.app.Application;

/**
 * Created by 112916 on 11/19/17.
 */

public class DogsParadise extends Application {

	private static NetworkComponent networkComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		/*in the below dagger object graph i am not including .networkModule(new NetworkModule())
		as it hase implicit default constructor and doesn't require external state to be passed in as parameter
		and dagger can handle these kind of modules*/

		networkComponent = DaggerNetworkComponent
				.builder().build();
	}

	public static NetworkComponent getNetworkComponent() {
		return networkComponent;
	}
}

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
		networkComponent = DaggerNetworkComponent
				.builder()
				.networkModule(new NetworkModule()).build();
	}

	public static NetworkComponent getNetworkComponent() {
		return networkComponent;
	}
}

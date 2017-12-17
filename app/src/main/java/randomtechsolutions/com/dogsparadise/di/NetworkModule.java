package randomtechsolutions.com.dogsparadise.di;

import dagger.Module;
import dagger.Provides;
import randomtechsolutions.com.dogsparadise.Network.DogNetworkManager;
import randomtechsolutions.com.dogsparadise.Util.UrlManager;

/**
 * Created by nande on 10/18/2017.
 */

@Module
public class NetworkModule {


	public NetworkModule() {
	}

	@Provides
	DogNetworkManager provideDogNetworkManager(){
		return new DogNetworkManager(UrlManager.DOGS_API_BASE_URL);
	}

	/*@Provides
	DogsApi getDogsApi(DogNetworkManager dogNetworkManager){
		return dogNetworkManager.getDogsApi();
	}*/


}

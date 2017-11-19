package randomtechsolutions.com.dogsparadise.Network;


import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nande on 10/18/2017.
 */

public class DogNetworkManager {

	private DogsApi dogsApi;

	public DogNetworkManager(String baseUrl) {

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(baseUrl)
				.addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		this.dogsApi = retrofit.create(DogsApi.class);
	}

	public DogsApi getDogsApi() {
		return dogsApi;
	}
}

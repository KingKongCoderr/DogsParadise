package randomtechsolutions.com.dogsparadise.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nande on 10/18/2017.
 */

public class DogNetworkManager {
    
    public static final String baseUrl = "https://dog.ceo/";
    
    private DogsApi dogsApi;
    
    public DogNetworkManager() {
    
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

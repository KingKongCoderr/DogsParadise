package randomtechsolutions.com.dogsparadise.Network;

import randomtechsolutions.com.dogsparadise.Breeds;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nande on 10/18/2017.
 */

public interface DogsApi   {
    
    @GET("api/breeds/list")
    Call<Breeds> getBreeds();
}

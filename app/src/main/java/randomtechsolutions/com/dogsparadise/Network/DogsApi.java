package randomtechsolutions.com.dogsparadise.Network;

import java.util.List;

import io.reactivex.Observable;
import randomtechsolutions.com.dogsparadise.BreedImagePojo;
import randomtechsolutions.com.dogsparadise.Breeds;
import randomtechsolutions.com.dogsparadise.Dog;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nande on 10/18/2017.
 */

public interface DogsApi   {
    
    @GET("api/breeds/list")
    Call<Breeds> getBreeds();
    
    @GET("/api/breed/{breed}/images/random")
    Observable<BreedImagePojo> getDogImageUrl(@Path("breed") String breed);
}

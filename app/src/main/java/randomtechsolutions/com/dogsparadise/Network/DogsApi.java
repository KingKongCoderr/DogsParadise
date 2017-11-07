package randomtechsolutions.com.dogsparadise.Network;

import io.reactivex.Observable;
import randomtechsolutions.com.dogsparadise.model.BreedImagePojo;
import randomtechsolutions.com.dogsparadise.model.Breeds;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nande on 10/18/2017.
 */

public interface DogsApi   {
    
    @GET("api/breeds/list")
    Observable<Breeds> getBreeds();
    
    @GET("/api/breed/{breed}/images/random")
    Observable<BreedImagePojo> getDogImageUrl(@Path("breed") String breed);
}

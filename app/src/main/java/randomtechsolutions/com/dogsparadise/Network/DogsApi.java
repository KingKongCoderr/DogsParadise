package randomtechsolutions.com.dogsparadise.Network;

import io.reactivex.Observable;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.LocalBreedDetailPojo;
import randomtechsolutions.com.dogsparadise.model.BreedRandomImagePojo;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.BreedsPojo;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by nande on 10/18/2017.
 */

public interface DogsApi   {
    
    @GET("api/breeds/list")
    Observable<BreedsPojo> getBreeds();
    
    @GET("/api/breed/{breed}/images/random")
    Observable<BreedRandomImagePojo> getDogImageUrl(@Path("breed") String breed);

    @GET("/api/breed/{breedName}/images")
    Observable<LocalBreedDetailPojo> getDogDetail(@Path("breedName") String breedName);
}

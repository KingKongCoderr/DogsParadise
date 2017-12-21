package randomtechsolutions.com.dogsparadise.RoomDatabase.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import io.reactivex.Flowable;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.BreedsPojo;

/**
 * Created by Nandeesh on 12/20/17.
 */
@Dao
public interface BreedsDao {

	@Insert
	void insertBreeds(BreedsPojo breedsPojo);

	@Update
	void updateBreeds(BreedsPojo breedsPojo);

	@Delete
	void deleteBreeds(BreedsPojo breedsPojo);

	@Query("SELECT * FROM BreedsPojo")
	Flowable<BreedsPojo> getBreedsPojo();

}

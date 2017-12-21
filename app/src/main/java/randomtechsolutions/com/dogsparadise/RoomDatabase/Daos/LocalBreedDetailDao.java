package randomtechsolutions.com.dogsparadise.RoomDatabase.Daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import io.reactivex.Flowable;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.LocalBreedDetailPojo;

/**
 * Created by Nandeesh on 12/18/17.
 */

@Dao
public interface LocalBreedDetailDao {

	@Query("SELECT * FROM BreedDetail WHERE breed_name LIKE :name")
	Flowable<LocalBreedDetailPojo> getBreed(String name);

	@Insert
	void insertBreedDetail(LocalBreedDetailPojo localBreedDetailPojo);

	@Update
	void updateBreedDetail(LocalBreedDetailPojo... localBreedDetailPojos);

	@Delete
	void deleteBreedDetail(LocalBreedDetailPojo localBreedDetailPojo);
}

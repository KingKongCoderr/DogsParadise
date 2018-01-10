package randomtechsolutions.com.dogsparadise.RoomDatabase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.BreedsDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.LocalBreedDetailDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.LocalBreedDetailPojo;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.BreedsPojo;
import randomtechsolutions.com.dogsparadise.RoomDatabase.TypeConverter.BreedUrlConverter;

/**
 * Created by Nandeesh on 12/18/17.
 */

@Database(entities = {BreedsPojo.class, LocalBreedDetailPojo.class}, version = 1)
@TypeConverters(BreedUrlConverter.class)
public abstract class DogsParadiseDatabase extends RoomDatabase {

	public abstract BreedsDao getBreedsDao();

	public abstract LocalBreedDetailDao localBreedDetailDao();

}

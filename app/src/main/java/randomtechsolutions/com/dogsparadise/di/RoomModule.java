package randomtechsolutions.com.dogsparadise.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.BreedsDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.LocalBreedDetailDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.DogsParadiseDatabase;

/**
 * Created by Nandeesh on 12/20/17.
 */

@Module
public class RoomModule {

	private DogsParadiseDatabase database;

	@Singleton
	public RoomModule(Application application) {

		this.database = Room.databaseBuilder(application,
				DogsParadiseDatabase.class,"DogsParadiseDatabase").build();
	}

	@Provides
	@Singleton
	DogsParadiseDatabase getDatabase(){
		return database;
	}

	@Provides
	@Singleton
	BreedsDao getBreedsDao(DogsParadiseDatabase dogsParadiseDatabase){
		return dogsParadiseDatabase.getBreedsDao();
	}

	@Provides
	@Singleton
	LocalBreedDetailDao getBreedDetailDao(DogsParadiseDatabase dogsParadiseDatabase){
		return dogsParadiseDatabase.localBreedDetailDao();
	}

}

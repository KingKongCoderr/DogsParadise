package randomtechsolutions.com.dogsparadise.ViewModel;

import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.BreedsDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.LocalBreedDetailDao;

/**
 * Created by Nandeesh on 12/8/17.
 */

public class SelectedBreedViewModel {
	private String selectedBreedName;
	private BreedsDao breedsDao;
	private LocalBreedDetailDao localBreedDetailDao;

	public SelectedBreedViewModel(String selectedBreedName, BreedsDao breedsDao, LocalBreedDetailDao localBreedDetailDao) {
		this.selectedBreedName = selectedBreedName;
		this.breedsDao = breedsDao;
		this.localBreedDetailDao = localBreedDetailDao;
	}

}

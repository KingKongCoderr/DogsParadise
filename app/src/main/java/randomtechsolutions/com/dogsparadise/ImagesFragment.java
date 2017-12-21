package randomtechsolutions.com.dogsparadise;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.BreedsDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.Daos.LocalBreedDetailDao;
import randomtechsolutions.com.dogsparadise.RoomDatabase.DogsParadiseDatabase;
import randomtechsolutions.com.dogsparadise.ViewModel.SelectedBreedViewModel;
import randomtechsolutions.com.dogsparadise.databinding.FragmentSelectedBreedBinding;
import randomtechsolutions.com.dogsparadise.di.DogsParadise;

/**
 * Created by Nandeesh on 12/8/17.
 */

public class ImagesFragment extends Fragment {

	public static final String SELECTED_BREED = "selected_breed";

	private String selectedBreed = "";

	private SelectedBreedViewModel viewModel;
	private FragmentSelectedBreedBinding binding;

	@Inject
	private BreedsDao breedsDao;

	@Inject
	private LocalBreedDetailDao localBreedDetailDao;

	//public empty constructor
	public ImagesFragment() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DogsParadise.getApplicationComponent().inject(this);
		if (savedInstanceState != null) {
			selectedBreed = savedInstanceState.getString(SELECTED_BREED, "");
		}
		viewModel = new SelectedBreedViewModel(selectedBreed,breedsDao,localBreedDetailDao);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		//todo use viewmodel with repository pattern
		//View view = inflater.inflate(R.layout.fragment_selected_breed, container, false);
		binding = DataBindingUtil.inflate(inflater,R.layout.fragment_selected_breed,container,false);
		binding.setItem(viewModel);
		return binding.getRoot();
	}


	public static ImagesFragment newInstance(String selectedBreed) {
		Bundle args = new Bundle();
		args.putString(SELECTED_BREED, selectedBreed);
		ImagesFragment imagesFragment = new ImagesFragment();
		imagesFragment.setArguments(args);
		return imagesFragment;
	}

}

package randomtechsolutions.com.dogsparadise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import randomtechsolutions.com.dogsparadise.di.DogsParadise;

/**
 * Created by Nandeesh on 12/8/17.
 */

public class ImagesFragment extends Fragment {

	public static final String SELECTED_BREED = "selected_breed";

	//public empty constructor
	public ImagesFragment() {
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DogsParadise.getNetworkComponent().inject(this);
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		//todo use viewmodel with repository pattern
		View view = inflater.inflate(R.layout.fragment_selected_breed,container,false);

		return super.onCreateView(inflater, container, savedInstanceState);
	}


	public static ImagesFragment newInstance(String selectedBreed){
		Bundle args = new Bundle();
		args.putString(SELECTED_BREED,selectedBreed);
		ImagesFragment imagesFragment = new ImagesFragment();
		imagesFragment.setArguments(args);
		return imagesFragment;
	}

}

package randomtechsolutions.com.dogsparadise;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gtomato.android.ui.transformer.CoverFlowViewTransformer;
import com.gtomato.android.ui.widget.CarouselView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import randomtechsolutions.com.dogsparadise.Network.DogNetworkManager;
import randomtechsolutions.com.dogsparadise.Network.DogsApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BreedsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BreedsFragment extends Fragment implements Callback<Breeds> {
    
    // private OnFragmentInteractionListener mListener;
    private CarouselView carouselView, carouselViewBackground;
    private TextView label;
    private ProgressBar progressBar;
    private List<Dog> dogs;
    
    public BreedsFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_breeds, container, false);
        //FragmentBreedsBinding fragmentBreedsBinding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.fragment_breeds,container,false);
        carouselView = (CarouselView) v.findViewById(R.id.carousel);//fragmentBreedsBinding.carousel;
        carouselViewBackground = (CarouselView) v.findViewById(R.id.carousel_background);
        label = (TextView) v.findViewById(R.id.label_tv);// fragmentBreedsBinding.labelTv;
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        dogs = new ArrayList<>();
        
        //CarouselView carouselView = fragmentBreedsBinding.carousel;
        //carouselView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                
                DogNetworkManager networkManager = new DogNetworkManager();
                Call<Breeds> dogsApiCall = networkManager.getDogsApi().getBreeds();
                dogsApiCall.enqueue(BreedsFragment.this);
                
            }
        });
        thread.start();
        return v;
    }
    
    @Override
    public void onResponse(Call<Breeds> call, Response<Breeds> response) {
        Breeds breeds = response.body();
        dogs = getDogsWithImageUrl(breeds.getMessage());
        //carouselView.swapAdapter(new CarouselAdapter(getContext(),dogs),true);
        //carouselView.scrollToPosition(3);
        // carouselView.setAdapter(new CarouselAdapter(getContext(), dogs));
    }
    
    private List<Dog> getDogsWithImageUrl(List<String> message) {
        List<Dog> dogs = new ArrayList<>();
        DogNetworkManager dogNetworkManager = new DogNetworkManager();
        Observable.fromIterable(message)
                .flatMap(new Function<String, ObservableSource<BreedImagePojo>>() {
                    @Override
                    public ObservableSource<BreedImagePojo> apply(String s) throws Exception {
                        return dogNetworkManager.getDogsApi().getDogImageUrl(s);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BreedImagePojo>() {
                    int count = 0;
                    
                    @Override
                    public void onSubscribe(Disposable d) {
                        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
                        
                    }
                    
                    @Override
                    public void onNext(BreedImagePojo breedImagePojo) {
                        String url = breedImagePojo.getMessage();
                        dogs.add(new Dog(message.get(count), breedImagePojo.getMessage()));
                        count++;
                    }
                    
                    @Override
                    public void onError(Throwable e) {
                        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
                        
                    }
                    
                    @Override
                    public void onComplete() {
                        Toast.makeText(getContext()
                                , "oncomplete"
                                , Toast.LENGTH_SHORT).show();
                        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
                        progressBar.setVisibility(View.GONE);
                        carouselViewBackground.setAdapter(new ForgroundAdapter(R.layout.background_item,dogs,getContext()));
                       // carouselViewBackground.setAdapter(new CarouselAdapter(getContext(), dogs));
                        carouselView.setTransformer(new CoverFlowViewTransformer());
                        carouselView.setAdapter(new ForgroundAdapter(R.layout.dog_item,dogs,getContext()));
                        //carouselView.setAdapter(new CarouselAdapter(getContext(), dogs));
                        carouselView.setClipChildren(false);
                        carouselView.setClickToScroll(false);
                        // carouselView.setInfinite(true);
                        carouselView.setExtraVisibleChilds(6);
                        carouselView.setOnScrollListener(new CarouselView.OnScrollListener() {
                            @Override
                            public void onScrollEnd(CarouselView carouselView) {
                                super.onScrollEnd(carouselView);
                                carouselViewBackground.scrollToPosition(carouselView.getCurrentAdapterPosition());
                            }
                        });
                        carouselView.setOnItemClickListener((adapter, view, position, adapterposition) -> {
                            Toast.makeText(getContext()
                                    , dogs.get(position).getBreed()
                                    , Toast.LENGTH_SHORT).show();
                        });
                        
                        carouselView.setOnItemSelectedListener(new CarouselView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
                                if (dogs.size() > 0) {
                                    label.setText("Selected Position: " + adapterPosition + " " + dogs.get(position).getBreed());
                                }
                                carouselViewBackground.scrollToPosition(position);
                                //carouselView.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));
                            }
                            
                            @Override
                            public void onItemDeselected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
                            
                            }
                        });
                        
                    }
                });
        
        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
        return dogs;
        
    }
    
    @Override
    public void onFailure(Call<Breeds> call, Throwable t) {
        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
        
    }
   
    
  /*  // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/
    
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

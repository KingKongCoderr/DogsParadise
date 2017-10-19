package randomtechsolutions.com.dogsparadise;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private CarouselView carouselView;
    private TextView label;
    private List<Dog> dogs;
    
    public BreedsFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_breeds, container, false);
        dogs = new ArrayList<>();
        carouselView = (CarouselView)v.findViewById(R.id.carousel);
        label = (TextView)v.findViewById(R.id.label_tv);
        carouselView.setTransformer(new CoverFlowViewTransformer());
        carouselView.setAdapter(new CarouselAdapter(getContext(),new ArrayList<Dog>()));
        carouselView.setClipChildren(false);
        carouselView.setExtraVisibleChilds(6);
        carouselView.setOnItemSelectedListener(new CarouselView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
                label.setText("Selected Position: "+ adapterPosition);
                //carouselView.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));
            }
    
            @Override
            public void onItemDeselected(CarouselView carouselView, int position, int adapterPosition, RecyclerView.Adapter adapter) {
        
            }
        });
       Thread thread =  new Thread(new Runnable() {
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
        List<Dog> dogs = getDogsWithImageUrl(breeds.getMessage());
        carouselView.setAdapter(new CarouselAdapter(getContext(),dogs));
    }
    
    private List<Dog> getDogsWithImageUrl(List<String> message) {
        List<Dog> dogs = new ArrayList<>();
        String baseUrl = DogNetworkManager.baseUrl;
        String imagePath = "/api/breed/{breed name}/images/random";
        Uri.Builder builder = new Uri.Builder();
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
                         dogs.add(new Dog(message.get(count),breedImagePojo.getMessage()));
                         count++;
                    }
    
                    @Override
                    public void onError(Throwable e) {
                        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
    
                    }
    
                    @Override
                    public void onComplete() {
                        // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
    
                    }
                });
        
        /*for (String s: message){
            *//*builder.scheme("https").authority("dog.ceo").appendPath("api").appendPath("breed")
                    .appendPath(s)
                    .appendPath("images")
                    .appendPath("random").build();
            String apiPath = builder.toString();*//*
    
            Observable<BreedImagePojo> dogObservable = dogNetworkManager.getDogsApi().getDogImageUrl(s);
            Observable
                    .just(dogObservable)
                    *//*.flatMap(new Function<Observable<BreedImagePojo>, ObservableSource<?>>() {
                        @Override
                        public ObservableSource<?> apply(Observable<BreedImagePojo> breedImagePojoObservable) throws Exception {
                            return breedImagePojoObservable.subscribeOn(Schedulers.io());
                        }
                    })*//*
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe();
            
                    
            
        }*/
       // dogs.add(new Dog(s,breedImagePojos.get(0).getMessage()));
        return dogs;
        
    }
    
    private void onFailure(Throwable error) {
        Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
    
    }
    
    private void onResponse(List<BreedImagePojo> response) {
        
        String imgUrl = response.get(0).getMessage();
        //dogs.add(new Dog(s,response.get(0).getMessage()));
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

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

import com.gtomato.android.ui.transformer.CoverFlowViewTransformer;
import com.gtomato.android.ui.widget.CarouselView;

import java.util.ArrayList;

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
    
    public BreedsFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_breeds, container, false);
        carouselView = (CarouselView)v.findViewById(R.id.carousel);
        label = (TextView)v.findViewById(R.id.label_tv);
        carouselView.setTransformer(new CoverFlowViewTransformer());
        carouselView.setAdapter(new CarouselAdapter(getContext(),new ArrayList<String>()));
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
        carouselView.setAdapter(new CarouselAdapter(getContext(),breeds.getMessage()));
    }
    
    @Override
    public void onFailure(Call<Breeds> call, Throwable t) {
    
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

package randomtechsolutions.com.dogsparadise;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gtomato.android.ui.widget.CarouselView;
import com.squareup.picasso.Picasso;

import java.util.List;

import randomtechsolutions.com.dogsparadise.databinding.DogItemBinding;

/**
 * Created by nande on 10/17/2017.
 */

public class CarouselAdapter extends CarouselView.Adapter<CarouselAdapter.ViewHolder> {
    
    List<Dog> dogs;
    Context context;
    
    public CarouselAdapter(Context context, List<Dog> dogs) {
        this.dogs = dogs;
        this.context = context;
    }
    
    @BindingAdapter({"app:imgUrl","app:placeHolder","app:error"})
    public static void bindImageView(ImageView imageView, String imgUrl, Drawable placeHolder, Drawable error){
    
        Picasso
                .with(imageView.getContext())
                .load(imgUrl)
                .fit()
                .placeholder(placeHolder)
                .error(error)
                .into(imageView);
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DogItemBinding dogItemBinding =
                DogItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(dogItemBinding);
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindModel(dogs.get(position));
        // holder.viewgroup.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary,null));
    }
    
    @Override
    public int getItemCount() {
        return dogs.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder {
        
        private final DogItemBinding dogItemBinding;
        
        public ViewHolder(DogItemBinding binding) {
            super(binding.getRoot().getRootView());
            this.dogItemBinding = binding;
        }
        
        void bindModel(Dog dog) {
           // dogItemBinding.setDog(dog);
            dogItemBinding.executePendingBindings();
        }
        
        
        /*@Override
        public void onClick(View view) {
          //  Toast.makeText(view.getContext(), dogItemBinding.getDog().breed, Toast.LENGTH_SHORT).show();
        }*/
    }
    
    
}

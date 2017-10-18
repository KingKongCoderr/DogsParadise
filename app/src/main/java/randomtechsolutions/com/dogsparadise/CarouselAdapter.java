package randomtechsolutions.com.dogsparadise;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gtomato.android.ui.widget.CarouselView;

import java.util.List;

/**
 * Created by nande on 10/17/2017.
 */

public class CarouselAdapter extends CarouselView.Adapter<CarouselAdapter.ViewHolder> {
    
    List<String> dogs;
    Context context;
    
   
    
    public CarouselAdapter(Context context,List<String> dogs) {
        this.dogs = dogs;
        this.context = context;
    }
    
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.dog_item, parent, false);
        return new ViewHolder(v);
    }
    
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.breedTv.setText(dogs.get(position));
       // holder.viewgroup.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary,null));
    }
    
    @Override
    public int getItemCount() {
        return dogs.size();
    }
    
    public static class ViewHolder extends RecyclerView.ViewHolder{
    
        TextView breedTv;
        ConstraintLayout viewgroup;
        public ViewHolder(View itemView) {
            super(itemView);
            breedTv = itemView.findViewById(R.id.breed_tv);
            viewgroup = itemView.findViewById(R.id.viewgroup);
        }
    }
    
    
}

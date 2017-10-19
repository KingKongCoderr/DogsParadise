package randomtechsolutions.com.dogsparadise;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nande on 10/19/2017.
 */

public class ForgroundAdapter extends BaseAdapter {
    private final int layoutId;
    List<Dog> dogs;
    Context context;
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
    
    public ForgroundAdapter(int layoutId, List<Dog> dogs, Context context) {
        this.layoutId = layoutId;
        this.dogs = dogs;
        this.context = context;
    }
    
    @Override
    protected Object getObjForPosition(int position) {
        return dogs.get(position);
    }
    
    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutId;
    }
    
    @Override
    public int getItemCount() {
        return dogs.size();
    }
}

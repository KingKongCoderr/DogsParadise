package randomtechsolutions.com.dogsparadise.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import randomtechsolutions.com.dogsparadise.model.Dog;

/**
 * Created by nande on 10/19/2017.
 */

public class ForgroundAdapter extends BaseAdapter {
    private final int layoutId;
    List<Dog> dogs;
    Context context;
    
    @BindingAdapter({"app:imgUrl", "app:placeHolder", "app:error","app:shouldBlur"})
    public static void bindImageView(ImageView imageView
            , String imgUrl, Drawable placeHolder, Drawable error,boolean shouldBlur) {
        
        if(shouldBlur) {
            Picasso
                    .with(imageView.getContext())
                    .load(imgUrl)
                    .transform(new BlurTransformation(imageView.getContext(), 10, 20))
                    .fit()
                    .placeholder(placeHolder)
                    .error(error)
                    .into(imageView);
        }else {
            Picasso
                    .with(imageView.getContext())
                    .load(imgUrl)
                    .fit()
                    .placeholder(placeHolder)
                    .error(error)
                    .into(imageView);
    
        }
    }
    
/*    @BindingAdapter({"app:blurImage"})
    public static void blurImage(ImageView view, String dummyString) {
        Blurry.with(view.getContext())
                .radius(10)
                .sampling(8)
                //.color(Color.argb(66, 0, 255, 255))
                .async()
                .capture(view)
                .into(view);
                //.onto(view);
    }*/
    
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

package randomtechsolutions.com.dogsparadise.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gtomato.android.ui.widget.CarouselView;

/**
 * Created by nande on 10/19/2017.
 */

public abstract class BaseCarouselAdapter extends CarouselView.Adapter<MyViewHolder> {
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(
                layoutInflater, viewType, parent, false);
        return new MyViewHolder(binding);
    }
    
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Object obj = getObjForPosition(position);
        holder.bind(obj);
    }
    
    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }
    
    protected abstract Object getObjForPosition(int position);
    
    protected abstract int getLayoutIdForPosition(int position);
   
}

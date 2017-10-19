package randomtechsolutions.com.dogsparadise;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by nande on 10/19/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;
    
    public MyViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    
    public void bind(Object obj) {
        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }
}


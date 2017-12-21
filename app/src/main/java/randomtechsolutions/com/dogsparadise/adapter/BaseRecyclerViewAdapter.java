package randomtechsolutions.com.dogsparadise.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by Nandeesh on 12/21/17.
 */

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
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

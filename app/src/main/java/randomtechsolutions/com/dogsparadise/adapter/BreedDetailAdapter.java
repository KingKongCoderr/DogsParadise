package randomtechsolutions.com.dogsparadise.adapter;

import randomtechsolutions.com.dogsparadise.RoomDatabase.Entities.LocalBreedDetailPojo;

/**
 * Created by Nandeesh on 12/21/17.
 */

public class BreedDetailAdapter extends BaseRecyclerViewAdapter {
	private LocalBreedDetailPojo breedDetail;
	private int layout_id;

	public BreedDetailAdapter(LocalBreedDetailPojo breedDetail, int layout_id) {
		this.breedDetail = breedDetail;
		this.layout_id = layout_id;
	}

	@Override
	protected Object getObjForPosition(int position) {
		return ;
	}

	@Override
	protected int getLayoutIdForPosition(int position) {
		return layout_id;
	}

	@Override
	public int getItemCount() {
		return ;
	}
}

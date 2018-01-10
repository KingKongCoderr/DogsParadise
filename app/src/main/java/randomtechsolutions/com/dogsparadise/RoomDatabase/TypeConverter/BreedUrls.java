package randomtechsolutions.com.dogsparadise.RoomDatabase.TypeConverter;

import java.util.List;

/**
 * Created by Nandeesh on 1/10/18.
 */

public class BreedUrls  {

	private List<String> breedUrls;

	public BreedUrls(List<String> breedUrls) {
		this.breedUrls = breedUrls;
	}

	public List<String> getBreedUrls() {
		return breedUrls;
	}

	public void setBreedUrls(List<String> breedUrls) {
		this.breedUrls = breedUrls;
	}
}

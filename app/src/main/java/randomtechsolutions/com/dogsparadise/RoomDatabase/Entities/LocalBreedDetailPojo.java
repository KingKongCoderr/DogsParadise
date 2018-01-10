package randomtechsolutions.com.dogsparadise.RoomDatabase.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nandeesh on 12/18/17.
 */

@Entity(tableName = "BreedDetail")
public class LocalBreedDetailPojo {

	@PrimaryKey
	private int breedId;

	@Ignore
	@SerializedName("status")
	private String status;

	@ColumnInfo(name = "breed_name")
	private String breedName;

	@ColumnInfo(name = "breed_urls")
	@SerializedName("message")
	private List<String> breedUrl;

	@ColumnInfo(name = "favorite")
	private boolean isFavorite;

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean favorite) {
		isFavorite = favorite;
	}

	public int getBreedId() {
		return breedId;
	}

	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public List<String> getBreedUrl() {
		return breedUrl;
	}

	public void setBreedUrl(List<String> breedUrl) {
		this.breedUrl = breedUrl;
	}
}

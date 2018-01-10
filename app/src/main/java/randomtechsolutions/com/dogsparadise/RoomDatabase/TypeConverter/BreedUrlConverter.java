package randomtechsolutions.com.dogsparadise.RoomDatabase.TypeConverter;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nandeesh on 1/10/18.
 */

public class BreedUrlConverter {

	@TypeConverter
	public BreedUrls storedStringToLanguages(String value) {
		List<String> langs = Arrays.asList(value.split("\\s*,\\s*"));
		return new BreedUrls(langs);
	}

	@TypeConverter
	public String languagesToStoredString(BreedUrls cl) {
		String value = "";

		for (String lang :cl.getBreedUrls())
			value += lang + ",";

		return value;
	}

}

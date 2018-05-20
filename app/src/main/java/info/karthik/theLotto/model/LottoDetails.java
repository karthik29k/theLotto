package info.karthik.theLotto.model;

import android.support.annotation.NonNull;

public class LottoDetails {
	private String title;
	private String thumbnailUrl;

	public LottoDetails(@NonNull String name, @NonNull String thumbnailUrl) {
		this.title = name;
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

}

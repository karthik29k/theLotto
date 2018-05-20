package info.karthik.theLotto.adater;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import info.karthik.theLotto.R;
import info.karthik.theLotto.app.AppController;
import info.karthik.theLotto.model.LottoDetails;

public class CustomListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<LottoDetails> lottoDetailsItems;
	ImageLoader imageLoader;

	public CustomListAdapter(Activity activity, List<LottoDetails> lottoDetailsItems) {
		this.activity = activity;
		this.lottoDetailsItems = lottoDetailsItems;
		imageLoader = AppController.getInstance().getImageLoader();
	}

	@Override
	public int getCount() {
		return lottoDetailsItems.size();
	}

	@Override
	public Object getItem(int location) {
		return lottoDetailsItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null)
			convertView = inflater.inflate(R.layout.list_row, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

		NetworkImageView thumbNail = convertView.findViewById(R.id.thumbnail);
		TextView title = convertView.findViewById(R.id.title);

		// getting movie data for the row
		LottoDetails m = lottoDetailsItems.get(position);

		// thumbnail image
		thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
		
		// title
		title.setText(m.getTitle());

		return convertView;
	}

}
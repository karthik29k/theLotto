package info.karthik.theLotto;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.karthik.theLotto.adater.CustomListAdapter;
import info.karthik.theLotto.api.CompaniesApi;
import info.karthik.theLotto.app.AppController;
import info.karthik.theLotto.model.LottoDetails;

public class MainActivity extends Activity {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json URL
    private static final String URL = "https://api.thelott.com/svc/sales/vmax/web/data/lotto/companies";

    private List<LottoDetails> lottoDetailsList = new ArrayList<>();
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(info.karthik.theLotto.R.layout.activity_main);

        ListView listView = findViewById(info.karthik.theLotto.R.id.list);
        adapter = new CustomListAdapter(this, lottoDetailsList);
        listView.setAdapter(adapter);

        // Creating volley request obj
        JsonObjectRequest movieReq = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                getListener(),
                getErrorListener());

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

    }

    @NonNull
    private Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
            }
        };
    }

    @NonNull
    private Response.Listener<JSONObject> getListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                lottoDetailsList.addAll(CompaniesApi.fetchData(response));
                adapter.notifyDataSetChanged();
            }
        };
    }
}

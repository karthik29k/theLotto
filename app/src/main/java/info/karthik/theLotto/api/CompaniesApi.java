package info.karthik.theLotto.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.karthik.theLotto.model.LottoDetails;

/**
 * Created by ankireds on 5/20/18.
 */

public class CompaniesApi {

    public static List<LottoDetails> fetchData(JSONObject response) {
        List<LottoDetails> details = new ArrayList<>();
        try {
            JSONArray set = response.getJSONArray("Companies");
            for (int i = 0; i < set.length(); i++) {
                JSONObject obj = set.getJSONObject(i);
                LottoDetails lottoDetails = new LottoDetails(
                        obj.getString("CompanyDisplayName"),
                        obj.getString("CompanyLogoUrl"));
                details.add(lottoDetails);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return details;
    }
}

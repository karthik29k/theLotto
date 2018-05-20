package info.karthik.theLotto.api;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.karthik.theLotto.model.LottoDetails;

public class CompaniesApiTest extends TestCase {
    private String jsonString = "{\"Companies\":[{\"CompanyId\":\"GoldenCasket\",\"CompanyDisplayName\":\"Golden Casket\",\"CompanyDescription\":\"QLD Residents\",\"CompanyLogoUrl\":\"http://media.tatts.com/TattsServices/Lotto/Companies/GoldenCasket_v1.png\"}],\"ErrorInfo\":null,\"Success\":true}";

    public void testFetchData() throws Exception {
        JSONObject jsonObject = new JSONObject(jsonString);
        List<LottoDetails> lottoDetails = CompaniesApi.fetchData(jsonObject);
        assertEquals(1, lottoDetails.size());
        assertEquals("Golden Casket", lottoDetails.get(0).getTitle());
        assertEquals("http://media.tatts.com/TattsServices/Lotto/Companies/GoldenCasket_v1.png", lottoDetails.get(0).getThumbnailUrl());
    }

}
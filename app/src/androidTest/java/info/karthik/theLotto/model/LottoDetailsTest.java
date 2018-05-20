package info.karthik.theLotto.model;

import junit.framework.TestCase;

public class LottoDetailsTest extends TestCase {
    private LottoDetails lottoDetails = new LottoDetails("abc", "url");

    public void testGetTitle() throws Exception {
        assertEquals("abc", lottoDetails.getTitle());
    }

    public void testGetThumbnailUrl() throws Exception {
        assertEquals("url", lottoDetails.getThumbnailUrl());
    }

}
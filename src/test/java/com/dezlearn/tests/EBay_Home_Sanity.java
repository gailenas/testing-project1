package com.dezlearn.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EBay_Home_Sanity extends Abstract_Base_Test {
    //    @Test(dependsOnMethods = ({"ivesti_metodo_pavadinima_nuo kurio priklauso testas"}, alwaysRun=true/false)
    @Test
    public void empty_search_test() {
        App().Flow().navigate_to_url("https://www.ebay.com/");

        String expectedUrl = "https://www.ebay.com/n/all-categories";
        String expectedTitle = "Shop by Category | eBay";

        Assert.assertTrue(App().Pages().HomePage().isSearchButtonEnabled(), "Validate if search button enabled");

        App().Pages().HomePage().clickSearchButton();

        String newUrl = driver.getCurrentUrl();
        String newTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, newTitle, "Validate if title is correct");
        Assert.assertEquals(expectedUrl, newUrl, "Validate if URL is correct");
    }

    @Test(groups = {"P1"})
    public void search_test() {
        App().Flow().navigate_to_url("https://www.ebay.com/");

        String keyword1 = "leather";
        String keyword2 = "wallet";

        App().Pages().HomePage().fillSearchInputField(keyword1, keyword2);
        App().Pages().HomePage().clickSearchButton();

        Assert.assertTrue(App().Pages().SearchResultsPage().getFirstSearchResultTitle().contains(keyword1), "Validate if search result contains keyword: " + keyword1);
        Assert.assertTrue(App().Pages().SearchResultsPage().getFirstSearchResultTitle().contains(keyword2), "Validate if search result contains keyword: " + keyword2);
    }
}

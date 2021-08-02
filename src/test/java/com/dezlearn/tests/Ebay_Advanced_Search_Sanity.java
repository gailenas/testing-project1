package com.dezlearn.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ebay_Advanced_Search_Sanity extends Abstract_Base_Test {
    @Test(groups = {"P0", "P1"})
    public void empty_advanced_search_test() {
        App().Flow().navigate_to_url("https://www.ebay.com/sch/ebayadvsearch");

        String expectedUrl = "https://www.ebay.com/n/all-categories";
        String expectedTitle = "Shop by Category | eBay";

        Assert.assertTrue(App().Pages().AdvancedSearchPage().isSearchButtonEnabled(), "Verify that search button is enabled");

        App().Pages().AdvancedSearchPage().clickAdvancedPageSearchButton();

        String newUrl = App().Flow().get_page_url();
        String newTitle = App().Flow().get_page_title();

        Assert.assertEquals(expectedUrl, newUrl, "Verify if empty search redirects to correct link");
        Assert.assertEquals(expectedTitle, newTitle, "Verify if title matches");
    }

    @Test(groups = {"P0"})
    public void category_options_in_ascending_order_test() {
        App().Flow().navigate_to_url("https://www.ebay.com/sch/ebayadvsearch");
        List<WebElement> category_options = App().Pages().AdvancedSearchPage().returnAllSelectedCategories();
        List<String> arr1 = new ArrayList<>();

        for (WebElement option : category_options) {
            arr1.add(option.getText());
        }
        List<String> arr2 = new ArrayList<>(arr1);
        Collections.sort(arr2);

        System.out.println("Actual list: " + arr1);
        System.out.println("Sorted list: " + arr2);

        Assert.assertNotEquals(arr1, arr2, "Verify that category items sorted");
    }

    @Test(groups = {"p1"})
    public void ebay_logo_navigates_to_home_page_test() {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");

        String expectedUrl = "https://www.ebay.com/";
        App().Pages().AdvancedSearchPage().clickEbayLogo();
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, currentUrl, "Verify that logo routing to home page");
    }

    @Test
    public void advanced_search_keywords_test() {
        App().Flow().navigate_to_url("https://www.ebay.com/sch/ebayadvsearch");
        String keyword1 = "leather";
        String keyword2 = "wallet";

        App().Pages().AdvancedSearchPage().fillAdvancedSearchInputField(keyword1, keyword2);
        App().Pages().AdvancedSearchPage().clickAdvancedPageSearchButton();

        System.out.println(App().Pages().SearchResultsPage().getFirstAdvancedSearchResultTitle());

        Assert.assertTrue(App().Pages().SearchResultsPage().getFirstAdvancedSearchResultTitle().toLowerCase().contains(keyword1), "Verify that " + keyword1 + " were found");
        Assert.assertTrue(App().Pages().SearchResultsPage().getFirstAdvancedSearchResultTitle().toLowerCase().contains(keyword2), "Verify that " + keyword2 + " were found");

    }
}

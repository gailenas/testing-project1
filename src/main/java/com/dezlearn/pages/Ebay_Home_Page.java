package com.dezlearn.pages;

import com.dezlearn.elements.Ebay_Home_Page_Elements;
import com.dezlearn.elements.Ebay_Search_Results_Page_Elements;
import org.openqa.selenium.WebDriver;

public class Ebay_Home_Page {
    WebDriver driver;
    Ebay_Home_Page_Elements ebayHomePageElements;
    Ebay_Search_Results_Page_Elements ebaySearchResultsPageElements;

    public Ebay_Home_Page(WebDriver driver) {
        this.driver = driver;
        ebayHomePageElements = new Ebay_Home_Page_Elements(driver);
        ebaySearchResultsPageElements = new Ebay_Search_Results_Page_Elements(driver);
    }

    public boolean isSearchButtonEnabled() {
        return ebayHomePageElements.searchBtn.isEnabled();
    }

    public void clickSearchButton() {
        ebayHomePageElements.searchBtn.click();
    }

    public void fillSearchInputField(String keyword1, String keyword2) {
        ebayHomePageElements.searchInputField.sendKeys(keyword1.toLowerCase() + " " + keyword2.toLowerCase());

    }
}

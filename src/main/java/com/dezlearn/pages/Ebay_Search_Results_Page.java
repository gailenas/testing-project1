package com.dezlearn.pages;

import com.dezlearn.elements.Ebay_Search_Results_Page_Elements;
import org.openqa.selenium.WebDriver;

public class Ebay_Search_Results_Page {
    WebDriver driver;
    Ebay_Search_Results_Page_Elements ebaySearchResultsPageElements;

    public Ebay_Search_Results_Page(WebDriver driver) {
        this.driver = driver;
        ebaySearchResultsPageElements = new Ebay_Search_Results_Page_Elements(driver);
    }

    public String getFirstAdvancedSearchResultTitle() {
        return ebaySearchResultsPageElements.firstSearchResultTitleAdvanced.getText();
    }

    public String getFirstSearchResultTitle() {
        return ebaySearchResultsPageElements.firstSearchResultTitle.getText().toLowerCase();
    }
}

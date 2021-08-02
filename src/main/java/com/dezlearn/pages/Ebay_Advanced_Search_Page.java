package com.dezlearn.pages;

import com.dezlearn.elements.Ebay_Advanced_Search_Page_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ebay_Advanced_Search_Page {
    WebDriver driver;
    Ebay_Advanced_Search_Page_Elements ebayAdvancedSearchPageElements;


    public Ebay_Advanced_Search_Page(WebDriver driver) {
        this.driver = driver;
        ebayAdvancedSearchPageElements = new Ebay_Advanced_Search_Page_Elements(driver);
    }

    public boolean isSearchButtonEnabled() {
        return ebayAdvancedSearchPageElements.advSearchBtn.isEnabled();
    }

    public void clickAdvancedPageSearchButton() {
        ebayAdvancedSearchPageElements.advSearchBtn.click();
    }

    public List<WebElement> returnAllSelectedCategories() {
        return ebayAdvancedSearchPageElements.allCatSelectBoxOptions;
    }

    public void clickEbayLogo() {
        ebayAdvancedSearchPageElements.ebayLogo.click();
    }

    public void fillAdvancedSearchInputField(String keyword1, String keyword2) {
        ebayAdvancedSearchPageElements.keywordsField.sendKeys(keyword1 + " " + keyword2);
    }
}

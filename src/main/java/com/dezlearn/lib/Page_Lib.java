package com.dezlearn.lib;

import org.openqa.selenium.WebDriver;
import com.dezlearn.pages.Ebay_Advanced_Search_Page;
import com.dezlearn.pages.Ebay_Home_Page;
import com.dezlearn.pages.Ebay_Search_Results_Page;

public class Page_Lib {

    private WebDriver driver;
    private Ebay_Home_Page ebayHomePage;
    private Ebay_Advanced_Search_Page ebayAdvancedSearchPage;
    private Ebay_Search_Results_Page ebaySearchResultsPage;

    public Page_Lib(WebDriver driver) {
        this.driver = driver;
        ebayHomePage = new Ebay_Home_Page(this.driver);
        ebayAdvancedSearchPage = new Ebay_Advanced_Search_Page(this.driver);
        ebaySearchResultsPage = new Ebay_Search_Results_Page(this.driver);
    }

    public Ebay_Home_Page HomePage() {
        return ebayHomePage;
    }

    public Ebay_Advanced_Search_Page AdvancedSearchPage() {
        return ebayAdvancedSearchPage;
    }

    public Ebay_Search_Results_Page SearchResultsPage() {
        return ebaySearchResultsPage;
    }
}

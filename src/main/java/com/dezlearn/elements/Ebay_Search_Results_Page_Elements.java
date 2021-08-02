package com.dezlearn.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ebay_Search_Results_Page_Elements {

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3")
    public WebElement firstSearchResultTitle;
    
    @FindBy(xpath = "//ul[@id='ListViewInner']/descendant::h3[1]")
    public WebElement firstSearchResultTitleAdvanced;

    public Ebay_Search_Results_Page_Elements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

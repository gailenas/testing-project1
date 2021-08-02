package com.dezlearn.lib;

import org.openqa.selenium.WebDriver;

public class Flow_Lib {

    private WebDriver driver;

    public Flow_Lib(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate_to_url(String url) {
        this.driver.get(url);
    }

    public String get_page_url() {
        return this.driver.getCurrentUrl();
    }

    public String get_page_title() {
        return this.driver.getTitle();
    }

}

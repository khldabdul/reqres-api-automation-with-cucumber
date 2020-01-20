package com.khalidabdul.runner;

import com.khalidabdul.ui.GooglePage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FirefoxRunner {

    // chrome, firefox, appium, remote
    @Managed(driver = "firefox")
    WebDriver driver;

    private GooglePage googlePage;

    @Test
    public void searchGoogleFirefox() {
//        sampleUI.doSearch();
    }
}

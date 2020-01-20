package com.khalidabdul.runner;

import com.khalidabdul.ui.GooglePage;
import com.khalidabdul.ui.YoutubePage;
import cucumber.api.java.en.Then;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class ChromeRunner {

    // chrome, firefox, appium, remote
    @Managed(driver = "chrome")
    WebDriver driver;

    private GooglePage googlePage;
    private YoutubePage youtubePage;

    @Test
    public void searchGoogleChrome() {
        googlePage.openHomePage();
        googlePage.doSearch("Food");
        List<String> list = googlePage.getSearchData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toLowerCase());
            assertThat(list.get(i).toLowerCase(), Matchers.containsString("food"));
            // di loop list nya
            // assert not case sensitive judulnya contains atau engga
        }
    }
        @Test
        public void searchYoutube() {
            youtubePage.openHomePage();
            youtubePage.doSearch("music video");
        }
}

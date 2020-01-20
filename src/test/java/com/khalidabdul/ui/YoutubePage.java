package com.khalidabdul.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.yecht.Data;

public class YoutubePage extends PageObject {

  @FindBy(xpath = "//input[@id='search']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//button[@id='search-icon-legacy']")
  WebElementFacade searchButton;

  public void openHomePage() {
    openUrl("https://www.youtube.com/");
  }

  public void doSearch(String value) {
    searchBox.click();
    searchBox.typeAndEnter(value);
    searchButton.click();
  }
}
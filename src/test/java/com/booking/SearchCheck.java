package com.booking;


import Constants.Month;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicPage;
import pages.CityPage;

import static Constants.Consts.*;

public class SearchCheck {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeTests(){
        System.setProperty("webdriver.chrome.driver", "F:/ForJava/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/index.en-gb.html");
        System.out.println("test start");
    }

    @AfterClass
    public static void afterTests(){
        driver.quit();
        System.out.println("test closed");
    }

    @Test
    public void searchHotelInCity(){
        BasicPage basicPage = new BasicPage(driver);
        CityPage cityPage = new CityPage(driver);

        basicPage.enterCityName(city);
        basicPage.enterCheckInAndCheckOutDate(checkInMonth, checkInDay, checkOutMonth, checkOutDay, checkInYear);
        basicPage.clickSearch();

        cityPage.checkCity(city);
        cityPage.checkDate(checkInMonth, checkInDay, checkOutMonth, checkOutDay, checkInYear);

    }


}

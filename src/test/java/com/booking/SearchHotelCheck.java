package com.booking;


import Constants.Month;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicPage;
import pages.CityPage;

import static Constants.Consts.*;

public class SearchHotelCheck {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeTests(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Open booking");
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

        System.out.println("Check city name");
        basicPage.enterCityName(city);
        System.out.println("Enter check in date and check out date");
        basicPage.enterCheckInAndCheckOutDate(checkInMonth, checkInDay, checkOutMonth, checkOutDay, checkInYear);
        System.out.println("Search");
        basicPage.clickSearch();

        System.out.println("Check sity");
        cityPage.checkCity(city);
        System.out.println("Сheck check-in and check-out date");
        cityPage.checkDate(checkInMonth, checkInDay, checkOutMonth, checkOutDay, checkInYear);

    }


}

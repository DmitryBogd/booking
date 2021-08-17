package com.booking;


import Constants.Month;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasicPage;

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

        basicPage.enterCityName("NewYork");
        basicPage.enterCheckInAndCheckOutDate(Month.April, 19,Month.May, 18, 2022);
        basicPage.clickSearch();


    }


}

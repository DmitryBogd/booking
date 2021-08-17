package com.booking;


import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchCheck {
    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeTests(){
        System.setProperty("webdriver.chrome.driver", "F:/ForJava/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.booking.com/index.en-gb.html");
    }

    @AfterClass
    public static void afterTests(){
        driver.quit();
    }


    @Test
    public void openBooking(){

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Booking.com | Official site | The best hotels & accommodation"));

    }


}

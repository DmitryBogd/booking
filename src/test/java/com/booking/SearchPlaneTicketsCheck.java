package com.booking;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PlanePage;


import static Constants.Consts.*;

public class SearchPlaneTicketsCheck {

    private static ChromeDriver driver;

    @BeforeClass
    public static void beforeTests(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Open booking");
        driver.get("https://www.booking.com/flights/index.en-gb.html");
        System.out.println("test start");
    }

    @AfterClass
    public static void afterTests(){
        driver.quit();
        System.out.println("test closed");
    }

    @Test
    public void searchPlaneToCity(){
        PlanePage planePage = new PlanePage(driver);

        System.out.println("Choose city");
        planePage.checkWhereFrom("Kiev");

        System.out.println("Choose airport");
        planePage.enterWhereTo("John F. Kennedy International Airport");

        System.out.println("Enter date");
        planePage.enterCheckInAndCheckOutDate(checkInMonth, checkInDay, checkOutMonth, checkOutDay, checkInYear);

        System.out.println("Click search");
        planePage.clickSearch();

        System.out.println("Check page");
        planePage.checkPage();
    }
}

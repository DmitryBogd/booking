package pages;

import Constants.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class CityPage {
    private WebDriver driver;

    public CityPage(WebDriver driver){
        this.driver = driver;
    }

    public void checkCity(String city){

        List<WebElement> webEleList = driver.findElements(By.cssSelector("a[class=\"bui-link\"]"));

        for (WebElement aElement:webEleList
             ) {
            if(!aElement.getText().contains(city))
               fail(" There is city not: "  +    city );
        }
        System.out.println("We have successfully checked city!");
    }
    public void checkDate(Month checkInMonth, int chekInDay, Month checkOutMonth, int chekOutDay, int year){
        List<WebElement> webEleList = driver.findElements(By.cssSelector("a[class=\"js-sr-hotel-link hotel_name_link url\"]"));

        for (WebElement aElement:webEleList
             ) {
            if(checkHotelDate(aElement, checkInMonth, chekInDay, checkOutMonth, chekOutDay, year));
            else
            fail("There is some problem with check in date or check out date");
        }
    }

    public boolean checkHotelDate(WebElement aElement, Month checkInMonth, int chekInDay, Month checkOutMonth, int chekOutDay, int year ){
        aElement.click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.id("av-summary-checkin")).click();


        if(driver.findElement(By.xpath("//span[contains(text(),'"+ chekInDay+ " " + checkInMonth + " "+ year+ "')]")).isEnabled()&&driver.findElement(By.xpath("//span[contains(text(),'"+ chekOutDay+ " " + checkOutMonth + " "+ year+ "')]")).isEnabled()) {
            driver.close();
            driver.switchTo().window(tabs2.get(0));
            return true;
        }
        else
        {
            driver.close();
            driver.switchTo().window(tabs2.get(0));
            return false;
        }
    }
}


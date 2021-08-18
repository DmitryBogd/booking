package pages;

import Constants.Month;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicPage {
    private  WebDriver driver;

    public BasicPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterCityName(String city){
        driver.findElement(By.id("ss")).sendKeys(city);
        System.out.println("We enter city: "+ city);
    }

    public void enterCheckInAndCheckOutDate(Month checkInMonth, int chekInDay, Month checkOutMonth, int chekOutDay, int year){
        driver.findElement(By.cssSelector("div[class=\"xp__dates xp__group\"]")).click();
        findMonthAndDayThenClick(checkInMonth,chekInDay,year);
        findMonthAndDayThenClick(checkOutMonth,chekOutDay,year);
    }

    private void findMonthAndDayThenClick(Month month, int day, int year){

        String name = driver.findElement(By.cssSelector("div[class=\"bui-calendar__month\"]")).getText();

        while (!name.equals(month + " " + year)) {
            driver.findElement(By.cssSelector("div[class=\"bui-calendar__control bui-calendar__control--next\"]")).click();
            name = driver.findElement(By.cssSelector("div[class=\"bui-calendar__month\"]")).getText();
        }
        driver.findElement(By.xpath("//span[.='"+ day +"']")).click();
        System.out.println("we have chosen a date: "+ day + " " + month + " " + year);

    }

    public void clickSearch(){
        driver.findElement(By.cssSelector("button[class=\"sb-searchbox__button \"]")).click();

    }
}

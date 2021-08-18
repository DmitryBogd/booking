package pages;

import Constants.Month;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.sql.DriverManager.getDriver;

public class PlanePage {
    private WebDriver driver;

    public PlanePage(WebDriver driver){
        this.driver = driver;
    }

    public void checkWhereFrom(String city){
        //class="Text-module__root--variant-body_2___2G9QY css-lilgi0"
        driver.findElement(By.cssSelector("div[class=\"Text-module__root--variant-body_2___2G9QY css-lilgi0\"]")).getText().equals(city);
    }

    public void enterWhereTo(String airport){
        driver.findElement(By.cssSelector("input[placeholder=\"Where to?\"]")).click();
        driver.findElement(By.cssSelector("input[class=\"css-156s1eu\"]")).sendKeys(airport);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class=\"ac-nested css-1ktdwgv\"]")));

        WebElement webElement = driver.findElement(By.cssSelector("li[class=\"ac-nested css-1ktdwgv\"]"));
        webElement.findElement(By.cssSelector("input[class=\"css-bwf0ll\"]")).click();
    }

    public void clickSearch(){
        driver.findElement(By.cssSelector("button[class=\"css-ya5gr9 wide\"]")).click();
    }

    public void enterCheckInAndCheckOutDate(Month checkInMonth, int chekInDay, Month checkOutMonth, int chekOutDay, int year){
        driver.findElement(By.cssSelector("div[class=\"css-ld8vwr\"")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"When?\"]")).click();
        findMonthAndDayThenClick(checkInMonth,chekInDay,year);
        findMonthAndDayThenClick(checkOutMonth,chekOutDay,year);
    }

    private void findMonthAndDayThenClick(Month month, int day, int year){

        String name = driver.findElement(By.cssSelector("div[class=\"Calendar-module__month___IU3eC\"]")).getText();

        while (!name.equals(month + " " + year)) {
            driver.findElement(By.cssSelector("button[class=\"Calendar-module__control___2XUQu Calendar-module__control--next___1iU98\"]")).click();
            name = driver.findElement(By.cssSelector("div[class=\"Calendar-module__month___IU3eC\"]")).getText();
        }
        driver.findElement(By.xpath("//span[.='"+ day +"']")).click();
        System.out.println("we have chosen a date: "+ day + " " + month + " " + year);

    }
    public void checkPage(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=\"css-17f6u3r-searchResultsList\"]")));

        driver.findElement(By.cssSelector("div[class=\"css-17f6u3r-searchResultsList\"]"));
    }
}

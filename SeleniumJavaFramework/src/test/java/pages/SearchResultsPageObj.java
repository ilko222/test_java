package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class SearchResultsPageObj {
    boolean statment = true;
    WebDriver driver = null;
    By add_close_btn = By.xpath("//span[@class='exponea-close-cross']");

    public SearchResultsPageObj(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkSearchedItems() {
        try {
            statment = driver.findElement(By.cssSelector(".catalog-grid__cell")).isDisplayed();
            return statment;
        } catch (StaleElementReferenceException e) {
            return statment = false;
        } catch (NoSuchElementException e) {
            return statment = false;
        }
        
    }
    public void closeAddBtn (){
        driver.findElement(add_close_btn).click();
    }
}
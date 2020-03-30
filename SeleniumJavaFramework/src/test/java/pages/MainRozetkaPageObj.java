package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainRozetkaPageObj {
    WebDriver driver = null;
    By textbox_search = By.xpath("//input[@name='search']");
    By button_search = By.cssSelector("button.search-form__submit");

    public MainRozetkaPageObj(WebDriver driver){
        this.driver = driver;
    }
public void setTextInSearchField(String text){
    driver.findElement(textbox_search).sendKeys(text);
}
public void clickSearchButton (){
    driver.findElement(button_search).click();
}

}
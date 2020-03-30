package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainRozetkaPage {
   private static WebElement element = null;

    public static WebElement searchField(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@name='search']"));
    return element;
}
public static WebElement searchButton(WebDriver driver) {
    element = driver.findElement(By.cssSelector("button.search-form__submit"));
return element;
}

}
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver",
                projectPath + "/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
       WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
       searchField.sendKeys("iphone");
       WebElement searchButton = driver.findElement(By.cssSelector("button.search-form__submit"));
       searchButton.click();
       Thread.sleep(3000);
       List<WebElement> searchResultsList = driver.findElements(By.cssSelector(".catalog-grid__cell"));
       int count = searchResultsList.size();
       System.out.println("Count of the elements = "+ count);
        driver.close();
    }
}
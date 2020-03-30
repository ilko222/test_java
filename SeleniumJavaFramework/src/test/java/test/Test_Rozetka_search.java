package test;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import helpers.dataProvider;
import pages.MainRozetkaPageObj;
import pages.SearchResultsPageObj;

public class Test_Rozetka_search {
    private static WebDriver driver = null;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setUpTest() {
        // start reporters
        htmlReporter = new ExtentHtmlReporter("report.html");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",
                projectPath + "/SeleniumJavaFramework/drivers/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = dataProvider.class)
    public void rozetkaSearch(String itemKey, String itemValue) throws Exception {
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Rozetka Search for "+itemValue, "Description");
        MainRozetkaPageObj mainPageObj = new MainRozetkaPageObj(driver);
        driver.get("https://rozetka.com.ua/");
        test.pass("Navigated to Rozetka");
        mainPageObj.setTextInSearchField(itemValue);
        test.pass("Searching for "+itemValue);
        mainPageObj.clickSearchButton();
        test.pass("Click Search Button");
        Thread.sleep(1000);
        verifySearchResults(itemValue);
        Thread.sleep(1000);
    }

    public void verifySearchResults(String item) throws Exception {
    ExtentTest test = extent.createTest("Rozetka Verifying Search Result for "+item, "Description");
        SearchResultsPageObj searchPageObj = new SearchResultsPageObj(driver);
        searchPageObj.closeAddBtn();
        test.info("Close Add button");
        if (searchPageObj.checkSearchedItems()){
            test.pass("Search item present.");
        }else{
            test.fail("No search results were found for"+item);
            throw new Exception("Can't find the search result item for "+item);
        }
}
@AfterSuite
public void tearDownTest(){
    driver.close();
    driver.quit();
    System.out.println("Test Compleated!");
    extent.flush();
}

}
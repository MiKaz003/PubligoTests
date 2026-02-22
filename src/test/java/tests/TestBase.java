package tests;

import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class TestBase {

    public WebDriver driver;
    private LoginPage loginPage;


    private final String url = PropertiesReader.read("url");


    @BeforeMethod
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("–-disable-search-engine-choice-screen");
        chromeOptions.addArguments("--disable-application-cache");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArgiment("--headless");

        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
        driver.get(url);

        loginPage.logIn();
        driver.findElement(By.xpath("//a[@class='ab-item']")).click();
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
}

package pages;

import config.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    private final String userName = PropertiesReader.read("loginToPubligo");
    private final String password = PropertiesReader.read("passwordToPubligo");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logIn(){
        driver.findElement(By.xpath("//a[@href='https://xczmepc414.wiedza.onl/moje-konto/']")).click();
        driver.findElement(By.id("edd_user_login")).sendKeys(userName);
        driver.findElement(By.id("edd_user_pass")).sendKeys(password);
        driver.findElement(By.id("edd_login_submit")).click();
    }
}

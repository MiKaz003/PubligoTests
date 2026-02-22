package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MediaPage {
    private WebDriver driver;

    public MediaPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='admin.php?page=wp-idea-videos']")
    private WebElement mediaButton;

    public void goToMedia(){
        mediaButton.click();
    }
}

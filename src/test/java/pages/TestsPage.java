package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestsPage {
    private WebDriver driver;

    public TestsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='admin.php?page=wp-idea-tests']")
    private WebElement testsButton;

    public void goToTests(){
        testsButton.click();
    }
}

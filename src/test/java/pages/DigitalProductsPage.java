package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class DigitalProductsPage extends TestBase {
    private WebDriver driver;

    public DigitalProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[@href='admin.php?page=publigo-digital-products']")
    private WebElement digitalProductsButton;

    public void goToDigitalProducts(){
        digitalProductsButton.click();
    }

}

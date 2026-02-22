package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhysicalProductPage {

    private WebDriver driver;

    public PhysicalProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='admin.php?page=publigo-physical-products']")
    private WebElement physicalProductButton;

    public void goToPhysicalProducts(){
        physicalProductButton.click();
    }
}

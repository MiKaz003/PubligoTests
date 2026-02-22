package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ServicesPage {

    private WebDriver driver;

    public ServicesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='admin.php?page=publigo-services']")
    private WebElement servicesButton;

    public void goToServices(){
        servicesButton.click();
    }
}

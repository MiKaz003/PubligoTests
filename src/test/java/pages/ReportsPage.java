package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {
    private WebDriver driver;

    public ReportsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='admin.php?page=publigo-sales-report']")
    private WebElement reportsButton;

    public void goToReports(){
        reportsButton.click();
    }
}

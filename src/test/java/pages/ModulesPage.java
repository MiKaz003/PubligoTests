package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulesPage {
    private WebDriver driver;

    public ModulesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='wp-has-submenu wp-not-current-submenu menu-top toplevel_page_wp-idea-courses']")
    private WebElement modulesButton;

    public void goToModules(){
        modulesButton.click();
    }

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentHistoryPage {
    private WebDriver driver;

    public PaymentHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='admin.php?page=wp-idea-payment-history']")
    private WebElement paymentHistoryButton;

    public void goToPaymentHistory(){
        paymentHistoryButton.click();
    }
}

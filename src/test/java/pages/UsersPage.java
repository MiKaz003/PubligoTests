package pages;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersPage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    final private Boolean deleteUserAfterTest = Boolean.parseBoolean(PropertiesReader.read("DeleteUserAfterTest"));

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@href='admin.php?page=wp-idea-users']")
    private WebElement usersButton;

    @FindBy(xpath = "//tbody[@role='rowgroup']//tr[@role='row']//td[@class='type-id']")
    private WebElement lastAddedUser;

    @FindBy(xpath = "//tbody[@role='rowgroup']//tr[@role='row']//button[@type='button']")
    private WebElement lastAddedUserMoreButton;

    @FindBy(xpath = "//tbody[@role='rowgroup']//tr[@role='row']//a[@class='row-action delete']")
    private WebElement deleteUserButton;

    @FindBy(id = "submit")
    private WebElement submitDeleteUser;

    @FindBy(xpath = "//a[contains(@class, 'added-user')]")
    private WebElement addUserButton;

    @FindBy(id = "user_login")
    private WebElement userNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "createusersub")
    private WebElement createUserButton;


    public void clickSafe(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysSafe(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }


    public Boolean getDeleteUserAfterTest() {
        return deleteUserAfterTest;
    }

    public void goToUsers() {
        clickSafe(usersButton);
    }

    public int getLastAddedUserId() {
        wait.until(ExpectedConditions.visibilityOf(lastAddedUser));
        String text = lastAddedUser.getText().replace("#", "").trim();
        return Integer.parseInt(text);
    }

    public void clickAddUserButton() {
        clickSafe(addUserButton);
    }

    public void sendUserName(String userName) {
        sendKeysSafe(userNameField, userName);
    }

    public void sendEmailAddress(String emailAddress) {
        sendKeysSafe(emailField, emailAddress);
    }

    public void sendFirstName(String firstName) {
        sendKeysSafe(firstNameField, firstName);
    }

    public void sendLastName(String lastName) {
        sendKeysSafe(lastNameField, lastName);
    }

    public void createUser() {
        clickSafe(createUserButton);
    }

    public void clickLastAddedUserMoreButton() {
        clickSafe(lastAddedUserMoreButton);
    }

    public void clickDeleteUserButton() {
        clickSafe(deleteUserButton);
    }

    public void clickSubmitDeleteUser() {
        clickSafe(submitDeleteUser);
    }

    public void deleteTestUser(){
        clickLastAddedUserMoreButton();
        clickDeleteUserButton();
        clickSubmitDeleteUser();
    }
}
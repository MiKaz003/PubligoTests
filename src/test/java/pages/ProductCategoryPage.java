package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductCategoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductCategoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='edit-tags.php?taxonomy=download_category&post_type=download']")
    private WebElement productCategoryButton;

    @FindBy(id = "tag-name")
    private WebElement nameField;

    @FindBy(id = "tag-slug")
    private WebElement simplifiedNameField;

    @FindBy(id = "tag-description")
    private WebElement descriptionField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(xpath = "//a[@aria-label='„Kategoria Testowa dla Kursow MZ” (Edycja)']")
    private WebElement newCategory;


    @FindBy(xpath = "//a[@href='admin.php?page=wp-idea-courses']")
    private WebElement coursesButton;

    @FindBy(xpath = "//*[text()='Kurs do Testowania']")
    private WebElement myCourse;

    @FindBy(xpath = "//*[@data-popup-id='categories_popup-additional-settings-popup']")
    private WebElement configureCategory;

    @FindBy(xpath = "//label[normalize-space()='Kategoria Testowa dla Kursow MZ']/input")
    private WebElement newCategoryCheckbox;

    @FindBy(id = "save-categories_popup-additional-settings-popup")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'snackbar') and contains(., 'zapisane')]")
    private WebElement snackBar;


    @FindBy(xpath = "//a[@class='delete']")
    private WebElement deleteButton;

    public void clickSafe(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendTextSafe(WebElement element, String key){
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(key);
    }

    public void goToProductCategory(){
        clickSafe(productCategoryButton);
    }

    public void sendName(String name){
        sendTextSafe(nameField, name);
    }

    public void sendSimplifiedName(String simplifiedName){
        sendTextSafe(simplifiedNameField, simplifiedName);
    }

    public void sendDescription(String description){
        sendTextSafe(descriptionField, description);
    }

    public void clickSubmit(){
        clickSafe(submitButton);
    }

    public Boolean isNewCategoryEnable(){
        return wait.until(ExpectedConditions.visibilityOf(newCategory)).isEnabled();
    }

    public void goToCourses(){
        clickSafe(coursesButton);
    }

    public void clickCourse(){
        clickSafe(myCourse);
    }


    public void clickConfigureCategory(){
        clickSafe(configureCategory);
    }

    public void clickCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(newCategoryCheckbox));
        if(!newCategoryCheckbox.isSelected()){
            newCategoryCheckbox.click();
        }
    }

    public void clickSaveCategoryButton(){
        clickSafe(saveButton);
    }

    public Boolean isSnackBarVisible(){
        try {
            wait.until(ExpectedConditions.visibilityOf(snackBar));
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public void clickNewCategory(){
        clickSafe(newCategory);
    }

    public void clickDeleteButton(){
        clickSafe(deleteButton);
    }

    public void alertAccept(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isCategoryPresent(){
        return driver.findElements(By.xpath("//a[@aria-label='„Kategoria Testowa dla Kursow MZ” (Edycja)']")).isEmpty();
    }
}

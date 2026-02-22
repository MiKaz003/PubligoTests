package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductTagsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductTagsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href='edit-tags.php?taxonomy=download_tag&post_type=download']")
    private WebElement productTag;

    @FindBy(id = "tag-name")
    private WebElement nameField;

    @FindBy(id = "tag-slug")
    private WebElement simplifiedNameField;

    @FindBy(id = "tag-description")
    private WebElement tagDescription;

    @FindBy(id = "submit")
    private WebElement addNewTagButton;


    @FindBy(id = "toplevel_page_wp-idea-courses")
    private WebElement coursesButton;

    @FindBy(xpath = "//*[text()='Kurs do Testowania']")
    private WebElement myCourse;

    @FindBy(xpath = "//*[@data-popup-id='tags_popup-additional-settings-popup']")
    private WebElement configureTags;

    @FindBy(xpath = "//*[@data-default='Dodaj tag']")
    private WebElement newTagInputField;

    @FindBy(id = "save-tags_popup-additional-settings-popup")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'snackbar') and contains(., 'zapisane')]")
    private WebElement snackBar;


    @FindBy(xpath = "//a[contains(@aria-label, 'Tag Testowy dla Kursow MZ') and contains(@aria-label, '(Edycja)')]")
    private WebElement newTag;

    @FindBy(xpath = "//a[@class='delete']")
    private WebElement deleteButton;


    public void clickSafe(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendTextSafe(WebElement element, String key){
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(key);
    }


    public void goToProductTags(){
        clickSafe(productTag);
    }

    public void sendName(String name){
        sendTextSafe(nameField, name);
    }

    public void sendSimplifiedName(String simplifiedName){
        sendTextSafe(simplifiedNameField, simplifiedName);
    }

    public void sendDescription(String description){
        sendTextSafe(tagDescription, description);
    }

    public void clickAddNewTagButton(){
        clickSafe(addNewTagButton);
    }

    public boolean checkIfNewTagExist() {
        while (true) {
            if (!driver.findElements(By.xpath("//a[contains(@aria-label, 'Tag Testowy dla Kursow MZ') and contains(@aria-label, '(Edycja)')]")).isEmpty()) {
                return true;
            } else if (!driver.findElements(By.xpath("//div[@class='tablenav bottom'] //a[@class='next-page button']")).isEmpty()) {
                clickSafe(driver.findElement(By.xpath("//div[@class='tablenav bottom'] //a[@class='next-page button']")));
            }else{
        return false;
            }
        }
    }

    public void goToCourses(){
        clickSafe(coursesButton);
    }

    public void goToMyCourse(){
        clickSafe(myCourse);
    }

    public void clickConfigureTag(){
        clickSafe(configureTags);
    }

    public void addNewTag(String newTag){
        sendTextSafe(newTagInputField, newTag);
    }

    public void clickSaveNewTags(){
        clickSafe(saveButton);
    }

    public boolean isSnackButtonVisible(){
        wait.until(ExpectedConditions.visibilityOf(snackBar));
        return snackBar.isDisplayed();
    }


    public void newTagClick(){
        clickSafe(newTag);
    }

    public void newTagDelete(){
        clickSafe(deleteButton);
    }

    public void alertAccept(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}

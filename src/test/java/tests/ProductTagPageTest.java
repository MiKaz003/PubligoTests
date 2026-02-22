package tests;

import config.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductTagsPage;

public class ProductTagPageTest extends TestBase {
    private ProductTagsPage productTagsPage;

    final private String tagName = PropertiesReader.read("ProductTagName");
    final private String tagSimplifiedName = PropertiesReader.read("ProduceTagSimplifiedName");
    final private String tagDescription = PropertiesReader.read("ProductTagDescription");

    @BeforeMethod
    public void setUp(){
        super.setUp();
        productTagsPage = new ProductTagsPage(driver);
        productTagsPage.goToProductTags();
    }

    @Test(priority = 10, description = "CreateNewTagTest")
    public void createNewTag(){
        productTagsPage.sendName(tagName);
        productTagsPage.sendSimplifiedName(tagSimplifiedName);
        productTagsPage.sendDescription(tagDescription);
        productTagsPage.clickAddNewTagButton();
        Assert.assertTrue(productTagsPage.checkIfNewTagExist());
    }

    @Test(priority = 20, description = "SetNewTagToCourse")
    public void setNewTagToCourse(){
        productTagsPage.goToCourses();
        productTagsPage.goToMyCourse();
        productTagsPage.clickConfigureTag();
        productTagsPage.addNewTag(tagName);
        productTagsPage.clickSaveNewTags();
        Assert.assertTrue(productTagsPage.isSnackButtonVisible());
    }

    @Test(priority = 30, description = "DeleteNewTag")
    public void deleteNewTag(){
        Assert.assertTrue(productTagsPage.checkIfNewTagExist());
        productTagsPage.newTagClick();
        productTagsPage.newTagDelete();
        productTagsPage.alertAccept();
        productTagsPage.goToProductTags();
        Assert.assertFalse(productTagsPage.checkIfNewTagExist());
    }
}

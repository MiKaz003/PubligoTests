package tests;

import config.PropertiesReader;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductCategoryPage;


public class ProductCategoryPageTest extends TestBase{
    public ProductCategoryPage productCategoryPage;

    private final String name = PropertiesReader.read("ProductCategoryName");
    private final String simplifiedName = PropertiesReader.read("ProductCategorySimplifiedName");
    private final String description = PropertiesReader.read("ProductCategoryDescription");

    @BeforeMethod
    public void setUp() {
        super.setUp();
        productCategoryPage = new ProductCategoryPage(driver);
        productCategoryPage.goToProductCategory();
    }

    @Test(description = "AddNewProductCategory")
    public void addNewProductCategory(){
        productCategoryPage.sendName(name);
        productCategoryPage.sendSimplifiedName(simplifiedName);
        productCategoryPage.sendDescription(description);
        productCategoryPage.clickSubmit();
        Assert.assertTrue(productCategoryPage.isNewCategoryEnable());
    }

    @Test(description = "ChangeProductCategory", enabled = true)
    public void changeProductCategory(){
        productCategoryPage.goToCourses();
        productCategoryPage.clickCourse();
        productCategoryPage.clickConfigureCategory();
        productCategoryPage.clickCategory();
        productCategoryPage.clickSaveCategoryButton();
        Assert.assertTrue(productCategoryPage.isSnackBarVisible());
    }

    @Test(description = "DeleteElement")
    public void deleteElement() {
        if (!productCategoryPage.isCategoryPresent()) {
            productCategoryPage.clickNewCategory();
            productCategoryPage.clickDeleteButton();
            productCategoryPage.alertAccept();
            boolean isDeleted = false;
            try {
                productCategoryPage.clickNewCategory();
            } catch (Exception e) {
                isDeleted = true;
            }
            Assert.assertTrue(isDeleted);
        } else {
            throw new SkipException("No category to remove");
        }
    }
}

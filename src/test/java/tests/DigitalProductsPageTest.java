package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DigitalProductsPage;

public class DigitalProductsPageTest extends TestBase{
    private DigitalProductsPage digitalProductsPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        digitalProductsPage = new DigitalProductsPage(driver);
        digitalProductsPage.goToDigitalProducts();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Produkty cyfrowe ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=publigo-digital-products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}

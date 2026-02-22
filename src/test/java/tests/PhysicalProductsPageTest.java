package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PhysicalProductPage;

public class PhysicalProductsPageTest extends TestBase {

    PhysicalProductPage physicalProductPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        physicalProductPage = new PhysicalProductPage(driver);
        physicalProductPage.goToPhysicalProducts();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Produkty fizyczne ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=publigo-physical-products";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

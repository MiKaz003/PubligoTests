package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ServicesPage;

public class ServicesPageTest extends TestBase{

    private ServicesPage servicesPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        servicesPage = new ServicesPage(driver);
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Usługi ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=publigo-services";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

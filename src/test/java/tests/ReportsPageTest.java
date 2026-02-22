package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ReportsPage;

public class ReportsPageTest extends TestBase{
    private ReportsPage reportsPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        reportsPage = new ReportsPage(driver);
        reportsPage.goToReports();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Raporty ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=publigo-sales-report";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

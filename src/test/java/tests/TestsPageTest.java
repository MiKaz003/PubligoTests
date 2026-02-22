package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestsPage;

public class TestsPageTest extends TestBase{
    private TestsPage testsPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        testsPage = new TestsPage(driver);
        testsPage.goToTests();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Zakończone testy ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=wp-idea-tests";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}

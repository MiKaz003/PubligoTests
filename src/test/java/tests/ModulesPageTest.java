package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ModulesPage;

public class ModulesPageTest extends TestBase{

    private ModulesPage modulesPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        modulesPage = new ModulesPage(driver);
        modulesPage.goToModules();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Kursy ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=wp-idea-courses";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

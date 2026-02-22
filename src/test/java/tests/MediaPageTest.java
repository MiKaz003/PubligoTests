package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MediaPage;;

public class MediaPageTest extends TestBase{
    private MediaPage mediaPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        mediaPage = new MediaPage(driver);
        mediaPage.goToMedia();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Wideo ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=wp-idea-videos";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

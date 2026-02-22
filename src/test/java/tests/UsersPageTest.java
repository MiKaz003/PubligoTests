package tests;

import config.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UsersPage;

public class UsersPageTest extends TestBase{

    private UsersPage usersPage;

    final private String userName = PropertiesReader.read("userName");
    final private String emailAddress = PropertiesReader.read("emailAddress");
    final private String firstName = PropertiesReader.read("firstName");
    final private String lastName = PropertiesReader.read("lastName");

    @BeforeMethod
    public void setUp(){
        super.setUp();
        usersPage = new UsersPage(driver);
        usersPage.goToUsers();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Użytkownicy ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=wp-idea-users";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test
    public void createNewUser(){
        final int currentLastUserId = usersPage.getLastAddedUserId();
        usersPage.clickAddUserButton();
        usersPage.sendUserName(userName);
        usersPage.sendEmailAddress(emailAddress);
        usersPage.sendFirstName(firstName);
        usersPage.sendLastName(lastName);
        usersPage.createUser();

        Assert.assertTrue(usersPage.getLastAddedUserId() >= currentLastUserId, "User was not added!");

        if(usersPage.getDeleteUserAfterTest()){
            usersPage.deleteTestUser();
        }
    }
}

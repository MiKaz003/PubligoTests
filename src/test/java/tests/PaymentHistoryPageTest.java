package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PaymentHistoryPage;

public class PaymentHistoryPageTest extends TestBase {
    private PaymentHistoryPage paymentHistoryPage;

    @BeforeMethod
    public void setUp(){
        super.setUp();
        paymentHistoryPage = new PaymentHistoryPage(driver);
        paymentHistoryPage.goToPaymentHistory();
    }

    @Test
    public void titleTest(){
        final String expectedTitle = "Zamówienia ‹ Platforma kursów online — WordPress";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test
    public void urlTest(){
        final String expectedUrl = "https://xczmepc414.wiedza.onl/wp-admin/admin.php?page=wp-idea-payment-history";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}

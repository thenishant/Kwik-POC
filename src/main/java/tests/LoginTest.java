package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    private void signIn() throws Exception {
        new LoginPage(driver).skipSplashScreen();
        for (int i = 0; i < 30; i++) {
            new LoginPage(driver).enterPhoneNumber("5123456789");
            new HomePage(driver).selectFoodItem();
        }
    }
}

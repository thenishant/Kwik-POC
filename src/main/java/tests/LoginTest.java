package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    private void signIn() throws Exception {
        new LoginPage(driver).skipSplashScreen();
        for (int i = 0; i < 10; i++) {
            new LoginPage(driver).enterPhoneNumber("5417573010");
            new HomePage(driver).selectFoodItem();
        }
    }
}

package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.app.kwik1:id/btn_skip")
    private WebElement skipButton;

    @FindBy(id = "com.app.kwik1:id/btnBrowse")
    private WebElement browseButton;

    @FindBy(id = "com.app.kwik1:id/auth_button")
    private WebElement loginButton;

    @FindBy(id = "com.app.kwik1:id/country_list")
    private WebElement countryList;

    @FindBy(xpath = "//*[@text='\uD83C\uDDEE\uD83C\uDDF3 India +91']")
    private WebElement india;

    @FindBy(id = "com.google.android.gms:id/credential_picker_layout")
    private WebElement crendtials;

    private By crendtialsBy = By.id("com.google.android.gms:id/credential_picker_layout");

    @FindBy(id = "android:id/text1")
    private List<WebElement> countires;

    @FindBy(id = "com.app.kwik1:id/phone_number")
    private WebElement phoneNumber;

    @FindBy(id = "com.app.kwik1:id/send_code")
    private WebElement verifyNumber;

    @FindBy(id = "com.app.kwik1:id/edit_phone_number")
    private WebElement editPhoneNumber;

    private By loginButtonId = By.id("com.app.kwik1:id/auth_button");

    public void skipSplashScreen() {
        waitForElementsToBeVisible(skipButton);
        skipButton.click();
    }

    public void enterPhoneNumber(String number) {
        waitForElementsToBeVisible(loginButton);
        loginButton.click();
        if (isElementPresent(crendtialsBy))
            driver.navigate().back();
        waitForElementsToBeVisible(phoneNumber);
        phoneNumber.sendKeys(number);
        waitForElementsToBeVisible(verifyNumber);
        verifyNumber.click();
        waitForElementsToBeVisible(editPhoneNumber);
        for (int i = 0; i < 10; i++) {
            if (isElementPresent(loginButtonId))
                break;
            driver.navigate().back();
        }
        waitForElementsToBeVisible(browseButton);
        browseButton.click();
    }

    public void loginScreenAction(String number) {
//        skipSplashScreen();
        enterPhoneNumber(number);
    }


}

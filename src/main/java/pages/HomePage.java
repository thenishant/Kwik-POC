package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) throws Exception {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "com.app.kwik1:id/itemImage")
    private List<WebElement> foodItemList;

    @FindBy(id = "com.app.kwik1:id/btn_productItemdetail_buynow")
    private WebElement buyNow;

    @FindBy(id = "com.app.kwik1:id/tb_switch_image")
    private WebElement seeIngredients;

    @FindBy(id = "com.app.kwik1:id/ib_close")
    private WebElement closeImage;

    @FindBy(id = "com.app.kwik1:id/spinner_nav")
    private WebElement openSpinner;

    @FindBy(id = "com.app.kwik1:id/rl_spinner_row")
    private List<WebElement> chooseType;

    @FindBy(id = "com.app.kwik1:id/action_kwik24_wifi")
    private WebElement switchToWifi;

    @FindBy(id = "android:id/button1")
    private WebElement register;

    @FindBy(xpath = "//*[@class='android.widget.ImageButton']")
    private WebElement openMenu;

    private By indredientsId = By.id("com.app.kwik1:id/tb_switch_image");

    public void selectFoodItem() {
        selectItemAndSeeDetails();
        waitForElementsToBeVisible(closeImage);
        closeImage.click();
        waitForElementsToBeVisible(openSpinner);
        openSpinner.click();
        waitForElementsToBeVisible(chooseType);
        chooseType.get(1).click();
        waitForElementsToBeVisible(switchToWifi);
        switchToWifi.click();
        driver.navigate().back();
        selectItemAndSeeDetails();
        waitForElementsToBeVisible(buyNow);
        buyNow.click();
        waitForElementsToBeVisible(register);
        register.click();
//        waitForElementsToBeVisible(openMenu);
//        openMenu.click();
    }

    private void selectItemAndSeeDetails() {
        waitForElementsToBeVisible(foodItemList);
        foodItemList.get(0).click();
        if (isElementPresent(indredientsId))
            seeIngredients.click();
    }
}

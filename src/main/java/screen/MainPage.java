package screen;

import base.BasePage;
import org.openqa.selenium.WebDriver;

import static constant.Constant.*;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }



    public void getHomePage() {
        navigateToUrl(URL_HEPSIEMLAK);

    }


    public void closeCookie() {
        clickElement(COOKIE_POLICY_BTN);


    }

    public void clickOnSatilik() {
        clickElement(SATILIK_BTN);
        sleep(400L);
    }

    public void clickOnKiralik() {
        clickElement(KIRALIK_BTN);
        sleep(400L);
    }


}


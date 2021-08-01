package screen;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.Constant.*;
import static org.junit.Assert.assertTrue;


public class KiralikPage extends BasePage {

    ArrayList<String> numbers = new ArrayList<>();

    public KiralikPage(WebDriver driver) {
        super(driver);
    }

    public void  clickOnFilter(){
        clickElement(FILTER_BUTTON);
 }

    public void choiceCity(String value) {


        clickElement(LOCATION_SELECT);
        //div[@class='city']/select/option[@value='izmir']
        scrollAndClick(By.xpath("//select/option[contains(text(),'"+value+"')]"));
        clickElement(LOCATION_SELECT);

    }

    public void clickOnCountry() {
        clickElement(COUNTRY_SELECT);

    }

    public void choiceCountry(String country) {
        scrollAndClick(By.xpath("//li/label[span[contains(text(),'"+country+"')]]"));

    }
    public void selectCategory() {
        scrollToElement(HOUSE_CAT_LABEL);
        clickElement(HOUSE_CAT_RADIO_BUTTON);

    }

    public void scrolltoRoomType() {
        scrollToElement(ROOM_TYPE_lABEL);
    }

    public void clickOnRoomType() {

        clickElement(ROOM_TYPE);
    }

    public void choiceRoomType(String temp) {
        System.out.println(temp);
        scrollAndClick(By.xpath("//li[./label/span[contains(text(),'" + temp + "')]]"));
    }

    public void clickSearchBtn() {
        clickElement(KIRALIK_SEARCH_BTN);
    }

    public void clickOnThirdItem() {
        clickElement(THIRD_ITEM);
    }

    public void clickToShowPhone() {
        clickElement(TEL_BTN);
    }
    public String getNumberPhone() {
        WebElement element = findElement(PHONE_NUMBERS);
        String phone = element.getAttribute("href");
        return phone.substring(6);

    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public void clickWithInSite() {
        scrollAndClick(WITH_IN_SITE);
    }
    public void applyFilter(){
        clickElement(COUNTRY_APPLY_FILTER);
    }

    public void applyRoomTypeFilter() {
        clickElement(ROOM_TYPE_APPLY_FILTER);
    }
}


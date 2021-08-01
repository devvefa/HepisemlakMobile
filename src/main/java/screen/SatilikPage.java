package screen;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constant.Constant.*;


public class SatilikPage extends BasePage {
    public SatilikPage(WebDriver driver) {
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
    public void applyFilter(){
        clickElement(COUNTRY_APPLY_FILTER);
    }

    public void selectCategory() {
        scrollToElement(CATEGORY_RADIO_BUTTON);
        clickElement(CATEGORY_RADIO_BUTTON);

    }

    public void enterMinPrice(String price) {
        scrollToElement(MIN_PRICE_INPUT);
        sendKeys(MIN_PRICE_INPUT, price);
    }

    public void enterMaxPrice(String price) {
        sendKeys(MAX_PRICE_INPUT, price);
    }


    public void clickBuildingAge() {
        scrollAndClick(BUILDINIG_AGE_SELECT);
    }

    public void choiceBuildingAge(String age) {
        scrollAndClick(By.xpath("//li/label[span[contains(text(),'"+age+"')]]"));
    }

    public void applyBuildingAgeFilter() {
        clickElement(BUILDINIG_APPLY_FILTER);
    }

    public String getCategoryText() {

        System.out.println("ssssssssssssssss ---- "+getText(SATILIK_LABEL));
        return getText(SATILIK_LABEL);
    }

    public ArrayList<String> filtredData() {
        ArrayList<String> filteredSatilik = new ArrayList();

        List<WebElement> elements = findElements(FILTERED_ELEMENTS);
        for (WebElement webElement : elements) {
            String name = webElement.getText();
            if (name.contains("TL")) {
               name=name.replaceAll("\\D+", "");
                    //   System.out.println(price);


            }
            // System.out.println(name);
            filteredSatilik.add(name);
        }
       // System.out.println(filteredSatilik);
        Collections.reverse(filteredSatilik);
        return  filteredSatilik;
    }
}


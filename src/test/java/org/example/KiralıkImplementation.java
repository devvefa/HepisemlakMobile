package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.apache.log4j.Logger;
import screen.KiralikPage;
import screen.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constant.Constant.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KiralıkImplementation {
    MainPage mainPage;
    KiralikPage kiralikPage;
    private static Logger logger = Logger.getLogger(KiralıkImplementation.class.getName());
    ArrayList<String> satilik = new ArrayList<>();

    @Step({"Anasayafa'ya gidilir", "Go to Home Page"})
    public void goToMainPage() {
        mainPage = new MainPage(Driver.driver);
        kiralikPage = new KiralikPage(Driver.driver);
        mainPage.getHomePage();
        mainPage.closeCookie();
        logger.info("hepsiemlak sitesi açıldı");


    }

    @Step("Check the home page is opened")
    public void checkMainPageIsOpened() {
        try {
            assertEquals(HEPSIEMLAK_PAGE_TITLE, mainPage.getTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Giris Yapildi");
        }
    }

    @Step("Click on “Kiralık”")
    public void clickOnKiralik() {
        mainPage.clickOnKiralik();
        logger.info("Menüden Kiralığa tıklandı");

    }

    @Step("click on filters")
    public void clickOnFilter() {
        kiralikPage.clickOnFilter();
        kiralikPage.sleep(450L);
        logger.info("filtirele tıklandı");

    }

    @Step("Check the kiralık page is opened.")
    public void checkKiralikPageIsOpened() {
        try {
            assertEquals(KIRALIK_PAGE_TITLE, kiralikPage.getTitle());
            logger.info("Kiralık Sayfasının açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Gidildi");
        }
    }

    @Step("Enter City as <name>")
    public void enterCityName(String name) {
        kiralikPage.choiceCity(name);
        logger.info("İl seçildi ");

    }

    @Step("Enter Countries as <table>")
    public void enterCountries(Table table) {
        kiralikPage.clickOnCountry();
        String country;
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();

        for (TableRow row : rows) {
            country = row.getCell(columnNames.get(0));

            kiralikPage.choiceCountry(country);

        }

        kiralikPage.applyFilter();
        logger.info("Ilçeler seçildi ");



    }

    @Step("Enter category as <konut>")
    public void selcetCategory(String konut) {
        kiralikPage.selectCategory();
        kiralikPage.sleep(700L);
        logger.info("Kategori seçildi ");

    }

    @Step("Enter room type as <room_type>")
    public void selectRoomType(Table room_type) {
        kiralikPage.scrolltoRoomType();
        kiralikPage.clickOnRoomType();
        String room;
        List<TableRow> rows = room_type.getTableRows();
        List<String> columnNames = room_type.getColumnNames();
        for (TableRow row : rows) {
            room = row.getCell(columnNames.get(0));

            kiralikPage.choiceRoomType(room);

        }
        kiralikPage.applyRoomTypeFilter();
        logger.info("Oda Sayısı seçildi ");


    }

    @Step("Select with in Site")
    public void selectWithInSite() {
        kiralikPage.clickWithInSite();
        logger.info("Site içinde checkbox'ı seçilir");

    }

    @Step("Click on Ara Button")
    public void clickOnSeachButton() {
        kiralikPage.clickSearchBtn();
        kiralikPage.sleep(2000L);
        logger.info("ara buttonuna tıklandı");


    }

    @Step("select 3rd item from list")
    public void clickOnThirdItem() {
        kiralikPage.clickOnThirdItem();
        logger.info("Listeden 3.ilan seçildi");

    }

    @Step("validate phone Number Real And Valid")
    public void phoneNumberRealAndValid() {
        Pattern pattern = Pattern.compile("^(0(\\d{10}))$");
        Matcher matcher = pattern.matcher(kiralikPage.getNumberPhone());
        assertTrue(matcher.matches());
        logger.info("ilan sahibinin telefon numaraları gerçek olup olmadığı kontrol edildi  ");

    }
}

package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.apache.log4j.Logger;

import screen.MainPage;
import screen.SatilikPage;
import java.util.ArrayList;
import java.util.List;

import static constant.Constant.HEPSIEMLAK_PAGE_TITLE;
import static constant.Constant.SATILIK_PAGE_TITLE;
import static org.junit.Assert.assertEquals;

public class SatilikImplementation {

    MainPage mainPage;
    SatilikPage satilikPage;
    private static Logger logger = Logger.getLogger(SatilikImplementation.class.getName());
    ArrayList<String> satilik = new ArrayList<>();


    @Step({"Ana sayafa'ya gidilir",
            "Go to Main Page"})
    public void goToMainPage() {
        mainPage = new MainPage(Driver.driver);
        satilikPage = new SatilikPage(Driver.driver);
        mainPage.getHomePage();
        mainPage.closeCookie();
        logger.info("Hepsiemlak Sayfası Açıldı");

    }


    @Step( "Check the main page is opened")
    public void checkMainPageIsOpened() {
        try {
            assertEquals(HEPSIEMLAK_PAGE_TITLE, mainPage.getTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Giris Yapildi");
        }
    }


    @Step({"Satılık sayfasına gidilir.", "Click on “Satılık”"})
    public void clickOnSatilik() {
        mainPage.clickOnSatilik();
        logger.info("Menüden satılığa tıklanır");

    }

    @Step({"Satılık Sayfasının açıldığı kontrol edilir.", "Check the satılık page is opened."})
    public void checkSatilıkPageIsOpened() {
        try {
            assertEquals(SATILIK_PAGE_TITLE, satilikPage.getTitle());

            logger.info("Satılık sayfasının  açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye gidildi");
        }
    }


    @Step("click on filter")
    public void clickOnFilter() {
        satilikPage.clickOnFilter();
        satilikPage.sleep(450L);
        satilik.add( satilikPage.getCategoryText());
        logger.info("filtirele tıklandı");

    }

    @Step("Enter City as  <value>")
    public void selcetCity(String value) {
      //  String a="Yalova";
        satilikPage.choiceCity(value);
        logger.info("İl seçildi ");

    }

    @Step("Enter Country as <table>")
    public void selectCounrties(Table table) {
        satilikPage.clickOnCountry();
        String country;
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        ArrayList<String> isimler = new ArrayList<>();

        for (TableRow row : rows) {
            country = row.getCell(columnNames.get(0));
            isimler.add(country);
            satilikPage.choiceCountry(country);

        }
            satilikPage.applyFilter();
        logger.info("Ilçeler seçildi ");

    }

    @Step("Enter category as  <type>")
    public void selectCategory(String type) {
        satilikPage.selectCategory();
        satilik.add(type);

        logger.info("Kategori seçildi ");

    }

    @Step("Enter minprice  as <value>")
    public void enterMinPrice(String value) {
        satilikPage.enterMinPrice(value);
        satilik.add(value);
        logger.info("En Az fiyat girildi ");

    }

    @Step("Enter maxprice  as <value>")
    public void enterMaxPrice(String value) {
        satilikPage.enterMaxPrice(value);
        satilik.add(value);
        logger.info("En Çok fiyat girildi ");

    }

    @Step("Enter building age as <table>")
    public void selcetBuildingAges(Table table) {
        satilikPage.clickBuildingAge();
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        String age;
        for (TableRow row : rows) {
            age = row.getCell(columnNames.get(0));
            satilikPage.choiceBuildingAge(age);
            satilik.add(age);

        }
        satilikPage.applyBuildingAgeFilter();
        logger.info("Bina yaşları seçildi ");

    }



    @Step("Check for Tags in the filter area")
    public void checkForTagsInFilterArea() {

      assertEquals(satilik, satilikPage.filtredData());
        logger.info("filtre alanındaki değerler girilen değerler ile aynı olduğu kontrol edildi");

    }
}

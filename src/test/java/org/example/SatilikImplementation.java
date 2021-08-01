package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import driver.Driver;
import org.apache.log4j.Logger;

import screen.MainScreeen;
import screen.SatilikPage;
import java.util.ArrayList;
import java.util.List;

import static constant.Constant.HEPSIEMLAK_PAGE_TITLE;
import static constant.Constant.SATILIK_PAGE_TITLE;
import static org.junit.Assert.assertEquals;

public class SatilikImplementation {

    MainScreeen mainScreeen;
    SatilikPage satilikPage;
    private static Logger logger = Logger.getLogger(SatilikImplementation.class.getName());
    ArrayList<String> satilik = new ArrayList<>();


    @Step({"Ana sayafa'ya gidilir",
            "Go to Main Page"})
    public void goToMainPage() {
        mainScreeen = new MainScreeen(Driver.driver);
        satilikPage = new SatilikPage(Driver.driver);
        mainScreeen.getHomePage();
        mainScreeen.closeCookie();
        logger.info("Hepsiemlak Sayfası Açıldı");

    }


    @Step( "Check the main page is opened")
    public void checkMainPageIsOpened() {
        try {
            assertEquals(HEPSIEMLAK_PAGE_TITLE, mainScreeen.getTitle());
            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Giris Yapildi");
        }
    }


    @Step({"Satılık sayfasına gidilir.", "Click on “Satılık”"})
    public void clickOnSatilik() {
        mainScreeen.clickOnSatilik();
        logger.info("Açılan pencereden Gömlek Seçildi");

    }

    @Step({"Satılık Sayfasının açıldığı kontrol edilir.", "Check the satılık page is opened."})
    public void checkSatilıkPageIsOpened() {
        try {
            assertEquals(SATILIK_PAGE_TITLE, satilikPage.getTitle());

            logger.info("Ana sayfanın açıldığı kontrol edilidi");

        } catch (Exception e) {
            logger.warn("Yanlış Siteye Giris Yapildi");
        }
    }


    @Step("click on filter")
    public void clickOnFilter() {
        satilikPage.clickOnFilter();
        satilikPage.sleep(450L);
        satilik.add( satilikPage.getCategoryText());
    }

    @Step("Enter City as  <value>")
    public void selcetCity(String value) {
      //  String a="Yalova";
        satilikPage.choiceCity(value);

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
    }

    @Step("Enter category as  <type>")
    public void selectCategory(String type) {
        satilikPage.selectCategory();
        satilik.add(type);


    }

    @Step("Enter minprice  as <value>")
    public void enterMinPrice(String value) {
        satilikPage.enterMinPrice(value);
        satilik.add(value);
    }

    @Step("Enter maxprice  as <value>")
    public void enterMaxPrice(String value) {
        satilikPage.enterMaxPrice(value);
        satilik.add(value);

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

    }



    @Step("print filter")
    public void implementation5() {

      assertEquals(satilik, satilikPage.filtredData());
        System.out.println("-------->"+satilikPage.filtredData());
        System.out.println("-------->"+satilik);

    }
}

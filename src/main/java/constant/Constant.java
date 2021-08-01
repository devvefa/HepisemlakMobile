package constant;

import org.openqa.selenium.By;

public class Constant {
    //----------Home Page---------
    public static final By ALISVERISE_BASLA_BUTTON = By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore");


    public static final String URL_HEPSIEMLAK = "https://www.hurriyetemlak.com";
    public static final String HEPSIEMLAK_PAGE_TITLE = "Hepsiemlak | Satılık, Kiralık Ev & Emlak İlanları";
    public static final By COOKIE_POLICY_BTN = By.xpath("//div[@class='cookie-policy']/button");

    public static final By SATILIK_BTN = By.xpath("//div[span[text()='Satılık']]");
    public static final By FILTER_BUTTON = By.xpath("//button[@class='btn btn-white'][2]");


    //----------Satılık Page---------

    public static final String SATILIK_PAGE_TITLE = "Satılık Konut İlanları ve Fiyatları | hepsiemlak";
        public static final By SATILIK_LABEL = By.xpath("//li[@data-v-32e46fa8 and @class='active']/a");

    public static final By LOCATION_SELECT = By.xpath("//div[@class='city']");
    public static final By COUNTRY_SELECT = By.xpath("//span[contains(text(),'İlçe Seçiniz')]   ");
    public static final By COUNTRY_APPLY_FILTER= By.xpath("//button[@data-v-7239b4cf and @class='btn btn-red filter-close']");

    public static final By CATEGORY_RADIO_BUTTON = By.xpath("//label[contains(text(),'İşyeri')]");

    public static final By BUILDINIG_AGE_SELECT = By.xpath("//span[contains(text(),'Bina Yaşı ')]");
    public static final By BUILDINIG_APPLY_FILTER = By.xpath("//div[ul[div[contains(text(),'Bina')]]]/button");

    public static final By MIN_PRICE_INPUT = By.xpath("//label[text()='En Az']/preceding-sibling::input");
    public static final By MAX_PRICE_INPUT = By.xpath("//label[text()='En Çok']/preceding-sibling::input");
    public static final By SEARCH_BTN = By.xpath("//a[@class='btn btn-red btn-large']");

    public static final By  FILTERED_ELEMENTS = By.xpath("//div[@class='inner']/div/p");


    //----------Kiralık Page---------
    public static final String KIRALIK_PAGE_TITLE = "Kiralık Konut Fiyatları ve İlanları | hepsiemlak";
    public static final By HOUSE_CAT_LABEL = By.xpath("//label[contains(text(),'Konut')]");
    public static final By HOUSE_CAT_RADIO_BUTTON = By.xpath("//label[contains(text(),'Konut')]");

    public static final By KIRALIK_BTN = By.xpath("//div[span[text()='Kiralık']]");
        public static final By ROOM_TYPE_lABEL = By.xpath("//section[@class='room-type']/div");
    public static final By ROOM_TYPE = By.xpath("//span[contains(text(),'Oda Seçiniz')]");
    public static final By ROOM_TYPE_APPLY_FILTER = By.xpath("//div[div[ul[div[contains(text(),'Oda Salon')]]]]/button");

    public static final By WITH_IN_SITE = By.xpath("//section/label[./span[contains(text(),'Site')]]");

    public static final By KIRALIK_SEARCH_BTN = By.xpath("//button[@class='btn btn-red cardShadow3 get-result']");

    public static final By THIRD_ITEM = By.xpath("(//div[@class='inner'])[3]");


    //----------Detail Page---------


    public static final By TEL_BTN = By.xpath("//div[@class='owner-phone-numbers']/button");
    public static final By PHONE_NUMBERS = By.xpath("//a[@class='btn btn-red btn-large full-button']");




}

package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class BasePage {
    protected WebDriver driver;

    WebDriverWait wait;



    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 30L, 500L);
    }

    public WebElement findElement(By by) {
        return  this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }




    public List<WebElement> findElements(By by) {
        return this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void clickElement(By by) {
        WebElement element = this.findElement(by);
          this.wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



    public void scrollToElement(By by) {
        WebElement element=findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollAndClick(By by) {
        WebElement element = findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void sendKeys(By by, CharSequence text) {
        sleep(440L);

        this.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }
    public String getTitle() {
        sleep(500L);
        return driver.getTitle();
    }
    public String getText(By by) {
        return findElement(by).getText();
    }



    public void sleep(Long milliSecond){
        try {
            Thread.sleep(milliSecond);
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }

//
//    protected void swipScreen() {
//      try{
//          new TouchAction(driver)
//                  .press(point(START_X, START_Y))
//                  .waitAction(waitOptions(Duration.ofMillis(WAIT_DURATION)))
//                  .moveTo(point(END_X, END_Y)).release().perform();
//      }
//      catch (InvalidElementStateException e ){
//          sleep(500);
//      }
//
//    }
}

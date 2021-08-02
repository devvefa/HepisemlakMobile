package driver;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {

    public static WebDriver driver;
    @BeforeScenario(tags = "mobile")
    public void initializeDriver() throws MalformedURLException {
        driver =   DriverFactory.getDriver();
    }

//    @BeforeScenario(tags ="web" )
//    public void initialize()  {
//        driver =   DriverFactory.getWebDriver();
//    }


    @AfterScenario
    public void closeDriver(){
        driver.quit();
    }

}

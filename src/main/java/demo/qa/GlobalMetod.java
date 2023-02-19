package demo.qa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static java.time.Duration.ofSeconds;

public class GlobalMetod {
    protected WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void ChromeOptions() {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--window-size=1200,1400");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(ofSeconds(15));
    }
  @AfterMethod(alwaysRun = true)
  public void closeDriver() {
    driver.quit();
    }

}

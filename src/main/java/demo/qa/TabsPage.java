package demo.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;


public class TabsPage {
    private final RemoteWebDriver driver;
    private static String PAGE_URL="https://demoqa.com/browser-windows";
    @FindBy(id = "tabButton")
    private WebElement newButton;


    public TabsPage(RemoteWebDriver driver) {
        driver.get(PAGE_URL);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNewButton(){

        String initialWindow = driver.getWindowHandle();
        newButton.click();

        assertEquals(driver.getWindowHandles().size(), 2, "Unexped number of window");
        String newWindowHandle = driver.getWindowHandles().stream()
                .filter(handle -> !handle.equals(initialWindow))
                .findFirst()
                .orElseThrow(() -> new AssertionError("New Windols handle was not added"));
        driver.switchTo().window(newWindowHandle);
        WebElement text = driver.findElement(By.id("sampleHeading"));
        assertEquals(text.getText(), "This is a sample page", "Unexpled page text");

    }
}

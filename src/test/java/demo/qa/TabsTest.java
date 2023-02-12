package demo.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TabsTest extends BaseTest {
    @BeforeMethod
    public void setUp() {
        driver.get("https://demoqa.com/browser-windows");
    }

    @Test
    public void TabsTest() {
        String initialWindow = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();

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


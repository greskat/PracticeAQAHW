package oldTest;

import demo.qa.GlobalMetod;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTest extends GlobalMetod {
    @BeforeMethod
    public void setUP() {
        driver.get("https://demoqa.com/slider");
    }

    @Test
    public void SliderTest() {

        WebElement inputRange = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/input"));
        WebElement inputText = driver.findElement(By.id("sliderValue"));

        int initialInputRangeValue = Integer.parseInt(inputRange.getAttribute("value"));

        int expectedInputRangeValue = 100;
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(inputRange, 200, 0).perform();
        int actualInputTextValue = Integer.parseInt(inputText.getAttribute("value"));

        assertEquals(expectedInputRangeValue, actualInputTextValue, "Unexpled number");
    }


}

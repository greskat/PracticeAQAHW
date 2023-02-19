package demo.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class SliderPage {
    private final RemoteWebDriver driver;
    private static String PAGE_URL = "https://demoqa.com/slider";

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/form/div/div[1]/span/input")
    WebElement inputRange;
    @FindBy(id = "sliderValue")
    WebElement inputText;

    public SliderPage(RemoteWebDriver driver) {
        driver.get(PAGE_URL);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputRange() {
        int initialInputRangeValue = Integer.parseInt(inputRange.getAttribute("value"));

        int expectedInputRangeValue = 100;
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(inputRange, 200, 0).perform();
    }

    public void setInputText(WebElement inputText) {
        this.inputText = inputText;
        int actualInputTextValue = Integer.parseInt(inputText.getAttribute("value"));
    }

     static {
        long expectedInputRangeValue = 0;
        long actualInputTextValue = 0;
        assertEquals(expectedInputRangeValue, actualInputTextValue, "Unexpled number");
    }
}

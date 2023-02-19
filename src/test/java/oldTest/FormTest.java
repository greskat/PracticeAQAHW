package oldTest;

import demo.qa.GlobalMetod;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.Keys.*;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class FormTest extends GlobalMetod {

    @BeforeMethod
    public void setUp() {
     driver.manage().window().setSize(new Dimension(600, 1200));
     driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void formTest() {

        this.subjects();
        this.putImages();
        this.calendar();

        driver.findElement(By.id("submit")).click();
        assertTrue(driver.findElement(By.id("example-modal-sizes-title-lg")).isDisplayed(),
                "Thanks for submitting the form");

        assertEquals(driver.getTitle(), "Thanks for submitting the form", "Thanks for submitting the form");
        this.assertText();

    }

    private void FillForm() {

    }

    protected void setFormData() {
        driver.findElement(By.id("firstName")).sendKeys("Taras");
        driver.findElement(By.id("lastName")).sendKeys("Petrenko");
        driver.findElement(By.id("userEmail")).sendKeys("gres@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("2211111111");
        driver.findElement(By.id("dateOfBirthInput")).click();
        driver.findElement(By.cssSelector(".react-datepicker__month-select")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[4]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[6]")).click();
    }
    protected void subjects() {
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subjects);
        subjects.click();
        subjects.sendKeys("Computer Science");
    }

    protected void putImages() {
        driver.findElement(By.xpath("//div/div/div/div/div/input")).sendKeys(TAB, SPACE);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[7]/div[2]/div[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[8]/div[2]/div/input")).sendKeys("C:\\Users\\kateryna.gres\\Desktop\\images_cat.jfif");
    }

    protected void calendar() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-3-input']"))).sendKeys("NCR");
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select')]"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-select-4-input']"))).sendKeys("Noida");
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id,'react-select')]"))).click();
    }

    protected void assertText() {
        assertTrue(driver.findElement(By.cssSelector("body > div.fade.modal.show > div > div > div.modal-body > div > table")).isDisplayed());
        assertEquals(driver.getTitle(),
                "Label Values\n" + "Student Name Taras Petrenko\n" +
                        "Student Email gres@gmail.com\n" + "Gender Other\n" + "Mobile 2211111111\n" +
                        "Date of Birth 14 April,2023\n" + "Subjects Computer Science\n" +
                        "Hobbies Sports\n" + "Picture images_cat.jfif\n" +
                        "Address\n" + "State and City NCR Noida", "Label Values\n" + "Student Name Taras Petrenko\n" +
                        "Student Email gres@gmail.com\n" + "Gender Other\n" + "Mobile 2211111111\n" +
                        "Date of Birth 14 April,2023\n" + "Subjects Computer Science\n" +
                        "Hobbies Sports\n" + "Picture images_cat.jfif\n" +
                        "Address\n" + "State and City NCR Noida");
    }
}
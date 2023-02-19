package demo.qa.form;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.Keys.SPACE;
import static org.openqa.selenium.Keys.TAB;

public class FormPage {
    private RemoteWebDriver driver;
    private static String PAGE_URL = "https://demoqa.com/automation-practice-form";

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement userEmail;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement genterWrapper;
    @FindBy(id = "userNumber")
    private WebElement userNumber;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement selectMounth;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement year;

    @FindBy(xpath = "//div[text()='18']")
    private WebElement day;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement checkboxHobbies;

    @FindBy(id = "subjectsInput")
    private WebElement subjects;

    @FindBy(id = "uploadPicture")
    private WebElement picture;

    @FindBy(id = "currentAddress")
    private WebElement address;
    @FindBy(id = "state")
    private WebElement state;
    @FindBy(xpath = "//div[text()='NCR']")
    private WebElement stateOption;

    @FindBy(id = "city")
    private WebElement city;


    @FindBy(xpath ="//div[text()='Delhi']")
    private WebElement cityOption;


    @FindBy(id = "submit")
    private WebElement submitButton;

    public FormPage(RemoteWebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String name) {
        firstName.click();
        firstName.sendKeys("Taras");
    }

    public void setLastName(String Lname) {
        lastName.click();
        lastName.sendKeys("Petrenko");
    }

    public void setUserEmail(String userEmail1) {
        userEmail.sendKeys("ekateryna.gres@gmail.com");
    }

    public void setGenterWrapper() {
        genterWrapper.click();
    }

    public void setUserNumber(String Number) {
        userNumber.sendKeys("2211111111");
    }

    public void setDateOfBirthInput() {
        dateOfBirthInput.click();
    }

    public void setSelectMounth() {
        Select selectMonth = new Select(selectMounth);
        selectMonth.selectByVisibleText("April");
    }

    public void setYear() {
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1990");

    }

    public void setDay() {
        day.click();
    }

    public void setCheckboxHobbies() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        checkboxHobbies.click();
    }

    public void setSubjects() {
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);
    }

    public void setPicture(){
        picture.sendKeys("C:\\Users\\kateryna.gres\\Desktop\\images_cat.jfif");

    }
    public void setAddress() {
        address.sendKeys("1222 Test");
    }

    public void setState() {
        state.click();
    }

    public void setStateOption() {
        stateOption.click();
    }

    public void setCity() {
        city.click();
    }

    public void setCityOption() {
        cityOption.click();

    }

    public void setSubmitButton() {
        submitButton.click();
    }

}








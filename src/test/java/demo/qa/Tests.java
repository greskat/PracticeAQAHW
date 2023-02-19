package demo.qa;


import demo.qa.form.FormModalWin;
import demo.qa.form.FormPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Tests extends GlobalMetod {
    private long expectedInputRangeValue;
    private long actualInputTextValue;

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void testFormt() {
        driver.manage().window().setSize(new Dimension(600, 1200));

        FormPage page = new FormPage((RemoteWebDriver) driver);

        page.setFirstName("");
        page.setLastName("");
        page.setUserEmail("");
        page.setGenterWrapper();
        page.setUserNumber("");
        page.setDateOfBirthInput();
        page.setSelectMounth();
        page.setYear();
        page.setDay();
        page.setSubjects();
        page.setCheckboxHobbies();
        page.setPicture();
        page.setAddress();
        page.setState();
        page.setStateOption();
        page.setCity();
        page.setCityOption();
        page.setSubmitButton();

    }
    public boolean formModalWin() {
        FormModalWin text = new FormModalWin((RemoteWebDriver) driver);
        Assert.assertTrue(text.setTitleModalForm());
        return false;
    }


    @Test
    public void tabTest() {
        TabsPage tabs = new TabsPage((RemoteWebDriver) driver);
        tabs.setNewButton();
    }

    @Test
    public void sliderTest() {
        SliderPage slider = new SliderPage((RemoteWebDriver) driver);
        slider.setInputRange();

    }

    private void assertEquals(long expectedInputRangeValue, long actualInputTextValue, String unexpledNumber) {
        assertEquals(this.expectedInputRangeValue, this.actualInputTextValue, "Unexpled number");
    }

}

package demo.qa.form;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FormModalWin {
    private RemoteWebDriver driver;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement titleModalForm;
    @FindBy(xpath = "/html/body/div[5]/div/div/div[2]/div/table")
    private WebElement dataSubmitForm;

    public FormModalWin(RemoteWebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean setTitleModalForm() {
        assertTrue(titleModalForm.isDisplayed(),
                "Thanks for submitting the form");

        assertEquals(titleModalForm.getSize(),
                "Thanks for submitting the form",
                "Thanks for submitting the form");


        //  public boolean setDataSubmitForm() {
        //      assertTrue(dataSubmitForm.isDisplayed());
        //      assertEquals(dataSubmitForm.getText(),
        //              "Student Name Taras Petrenko\n" +
        //                      "Student Email ekateryna.gres@gmail.com\n" + "Gender Other\n" + "Mobile 2211111111\n",
        //              "Student Name Taras Petrenko\n" +
        //                       "Student Email ekateryna.gres@gmail.com\n" + "Gender Other\n" + "Mobile 2211111111\n"
        //      );


     return false;
}

 }


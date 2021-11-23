package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutomationPracticeFormPage {
    private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(xpath = "//input[@name='gender']/../label")
    List<WebElement> genderRadioButtons;

    @FindBy(id = "userNumber")
    private WebElement userNumberInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement userDOBInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(css = "div.modal-body")
    private WebElement submitConfirmationModal;

    public AutomationPracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // int gender 0 -> Male, 1 -> Female, 2 -> Other
    public void enterUserData(String firstName, String lastName, String email, String mobile, String dateOfBirth, int gender) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        userEmailInput.click();
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
        // tu uwaga na błędy z wyjściem poza zakres listy
        genderRadioButtons.get(gender).click();
        userNumberInput.sendKeys(mobile);
        // format: 29 Apr 1987
        userDOBInput.click();

        // to nam nie działa userDOBInput.clear();
        userDOBInput.sendKeys(Keys.CONTROL + "A");
        userDOBInput.sendKeys(dateOfBirth);

        // przeskroluj widok do buttona
        userEmailInput.click();
        userEmailInput.sendKeys(Keys.PAGE_DOWN);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        submitButton.click();
    }

    public String getSubmitConfirmationMessage() {
        return submitConfirmationModal.getText();
    }

}

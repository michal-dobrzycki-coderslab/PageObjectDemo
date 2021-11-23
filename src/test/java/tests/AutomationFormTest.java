package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AutomationPracticeFormPage;

import java.util.concurrent.TimeUnit;

public class AutomationFormTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void shouldSubmitFormSuccessfully() {
        AutomationPracticeFormPage formPage = new AutomationPracticeFormPage(driver);
        String firstName = "Michał";
        String lastName = "Dobrzycki";

        // wypełnienie formularza
        formPage.enterUserData(firstName, lastName,
                                "md@coderslab.pl", "1234567890",
                                "16 Jun 1983", 0);

        // asercja na wyskakujące okno
        String confirmationText = formPage.getSubmitConfirmationMessage();
        Assert.assertTrue(confirmationText.contains(firstName));
        Assert.assertTrue(confirmationText.contains(lastName));
        Assert.assertTrue(confirmationText.contains("md@coderslab.pl"));
        Assert.assertTrue(confirmationText.contains("1234567890"));
    }


    @After
    public void tearDown() {
        // driver.quit();
    }
}

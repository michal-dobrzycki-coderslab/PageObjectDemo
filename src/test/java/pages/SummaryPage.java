package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePage {
    public SummaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="cart_summary")
    WebElement summaryTable;

    public String getRoomDescription() {
        return summaryTable
                .findElement(By.cssSelector("p.product-name"))
                .getText();
    }

    public String getCheckInDate() {
        return summaryTable
                .findElement(By.xpath("//td[@class='text-center'][2]"))
                .getText();
    }

    public String getCheckOutDate() {
        return summaryTable
                .findElement(By.xpath("//td[@class='text-center'][3]"))
                .getText();
    }
}

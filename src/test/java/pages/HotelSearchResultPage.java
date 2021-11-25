package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HotelSearchResultPage extends BasePage {
    public HotelSearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.room_cont")
    List<WebElement> availableHotelList;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;


    // zwróć liczbę znalezionych hoteli
    public boolean areAnyRoomsAvailable() {
        return availableHotelList.size()>0;
    }

    public String getFirstHotelName() {
        return availableHotelList
                .get(0)
                .findElement(By.cssSelector("p.rm_heading"))
                .getText();
    }

    public void bookFirstHotel() {
        availableHotelList
                .get(0)
                .findElement(By.cssSelector("a.ajax_add_to_cart_button"))
                .click();

        proceedToCheckoutButton.click();
    }
}

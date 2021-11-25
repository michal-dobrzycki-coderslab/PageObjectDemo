package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HotelHomePage extends BasePage {
    public HotelHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hotel_location")
    private WebElement hotelLocationInput;

    @FindBy(id = "hotel_cat_name")
    private WebElement hotelCategoryDropdown;

    @FindBy(css= "ul.hotel_dropdown_ul")
    List<WebElement> hotelCategoriesList;

    @FindBy(id = "check_in_time")
    private WebElement checkInTimeInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutTimeInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchButton;


    public void searchForHotel(String hotelLocation, String checkInDate, String checkOutDate) {
        hotelLocationInput.sendKeys(hotelLocation);
        hotelCategoryDropdown.click();
        hotelCategoriesList.get(0).click();
        checkInTimeInput.sendKeys(checkInDate);
        checkOutTimeInput.sendKeys(checkOutDate);

        searchButton.click();
    }

}

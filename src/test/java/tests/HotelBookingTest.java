package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HotelHomePage;
import pages.HotelSearchResultPage;
import pages.SummaryPage;

public class HotelBookingTest extends BaseTest {
    @Test
    public void shouldReserveHotelInFuture() throws InterruptedException {
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        HotelHomePage homePage = new HotelHomePage(driver);
        // wyszukaj hotel

        String checkinDate = "25-11-2021";
        String checkoutDate = "27-11-2021";

        homePage.searchForHotel("Warsaw", checkinDate, checkoutDate);
        // sprawdź że załadowały się jakieś wyniki
        HotelSearchResultPage searchResultPage = new HotelSearchResultPage(driver);
        // znaleźliśmy przynajmniej jeden element
        Assert.assertTrue(searchResultPage.areAnyRoomsAvailable());

        // zapisz nazwę hotelu do zmiennej
        String reservedHotel = searchResultPage.getFirstHotelName();

        // zarezerwuj hotel
        searchResultPage.bookFirstHotel();

        SummaryPage summaryPage = new SummaryPage(driver);
        // sprawdź w tabelce czy nazwa hotelu się zgadza z tą którą rezerwowaliśmy
        Assert.assertEquals(reservedHotel, summaryPage.getRoomDescription());
        Assert.assertEquals(checkinDate, summaryPage.getCheckInDate());
        Assert.assertEquals(checkoutDate, summaryPage.getCheckOutDate());
    }
}

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import pages.MyPage;

public class MejuriTest {

    @BeforeAll
    public static void setUp() {
        Selenide.open("https://mejuri.com/world/en");
        com.codeborne.selenide.Configuration.timeout = 10000;
    }

    @Test
    public void testMejuri() {
        new MyPage().navBarUserButton.click(); // click on user icon
        new MyPage().signInButton.click(); // click on sing in button
        new MyPage().emailInput.setValue("eeo24667@omeie.com"); // credentials were registered before tests, input email
        new MyPage().passwordInput.setValue("Qq123456"); // input password
        new MyPage().continueButton.click(); // click on continue button
        new MyPage().birthdayInput.setValue("12/12/2000"); // input birthday
        new MyPage().saveBirthdayButton.click(); // click on save birthday button
        new MyPage().searchIcon.click(); // click on search icon in navigation bar
        new MyPage().searchInput.setValue("Honey Mini Signet").click(); // input search word
        new MyPage().searchResult.shouldHave(text("Honey Signet")); // check that search result is valid
        new MyPage().searchResult.click(); // click on search result
        SelenideElement element = new MyPage().wishlistButton;
        actions().moveToElement(element).pause(500).click(element).perform();
        new MyPage().productName.shouldHave(text("Honey Mini Signet"));
    }
}

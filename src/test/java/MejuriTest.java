import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import org.openqa.selenium.By;

public class MejuriTest {
    private static final By navBarUserButton = By.cssSelector("[data-testid='nav-dp-l1-user-navigation-signup-icon']");
    private static final By signInButton = By.xpath("//a[@class='styled__ButtonWrapper-sc-1waring-0 iwImlv']");
    private static final By emailInput = By.cssSelector("input[name='email']");
    private static final By passwordInput = By.cssSelector("input[name='password']");
    private static final By continueButton = By.cssSelector("button[type='submit']");
    private static final By birthdayInput = By.cssSelector("[data-testid=\"birthdate-input\"]");
    private static final By saveBirthdayButton = By.cssSelector("[data-testid=\"save-birthdate-button\"]");
    private static final By searchIcon = By.cssSelector("button[aria-label='Search']");
    private static final By searchInput = By.cssSelector("[data-testid='main-search-input']");
    private static final By searchResult = By.cssSelector("[data-testid='product-card-title']");
    private  static  final  By wishlistButton = By.cssSelector("[data-testid=\"icon-whishlist-btn\"]");
    @BeforeAll
    public static void setUp() {
        Selenide.open("https://mejuri.com/world/en");
        com.codeborne.selenide.Configuration.timeout = 10000;
    }

    @Test
    public void testMejuri() {
        $(navBarUserButton).click(); // click on user icon
        $(signInButton).click(); // click on sing in button
        $(emailInput).setValue("eeo24667@omeie.com"); // credentials were registered before tests, input email
        $(passwordInput).setValue("Qq123456"); // input password
        $(continueButton).click(); // click on continue button
        $(birthdayInput).setValue("12/12/2000"); // input birthday
        $(saveBirthdayButton).click(); // click on save birthday button
        $(searchIcon).click(); // click on search icon in navigation bar
        $(searchInput).setValue("Honey Mini Signet").click(); // input search word
        $(searchResult).shouldHave(text("Honey Signet")); // check that search result is valid
        $(searchResult).click(); // click on search result
        $(wishlistButton).click(); // click on wishlist icon
    }
}

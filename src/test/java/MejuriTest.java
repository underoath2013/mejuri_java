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
//    private static final By productSize = By.cssSelector("[data-testid='product-size-message']");
//    private static final By ringLogo = By.cssSelector(".styled__Container-sc-aw9czy-0.boNuA-D");
    private static final By wishlistButton = By.cssSelector("[data-testid='icon-wishlist-btn']");

    @BeforeAll
    public static void setUp() {
        Selenide.open("https://mejuri.com/world/en");
        com.codeborne.selenide.Configuration.timeout = 10000;
    }

    @Test
    public void testMejuri() {
        $(navBarUserButton).click();
        $(signInButton).click();
        // Данного юзера заранее зарегистрировали
        $(emailInput).setValue("eeo24667@omeie.com");
        $(passwordInput).setValue("Qq123456");
        $(continueButton).click();
        $(birthdayInput).setValue("12/12/2000");
        $(saveBirthdayButton).click();
        $(searchIcon).click(); // не находит вот этот элемент и не кликает его
        $(searchInput).setValue("Honey Mini Signet").click();
        $(searchResult).shouldHave(text("Honey Signet"));
        $(searchResult).click();
        // Ждем перехода на страницу с товаром
//        $(productSize).shouldHave(text("Ring"), text("Size"));
//        $(ringLogo).shouldHave(text("Honey Mini Signet"));
        $(wishlistButton).click();
    }
}

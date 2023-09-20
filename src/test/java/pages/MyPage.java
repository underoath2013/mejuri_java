package pages;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MyPage {
    public SelenideElement navBarUserButton = $("[data-testid='nav-dp-l1-user-navigation-signup-icon']");

    public SelenideElement signInButton = $x("//a[@class='styled__ButtonWrapper-sc-1waring-0 iwImlv']");
    public SelenideElement emailInput = $("input[name='email']");
    public SelenideElement passwordInput = $("input[name='password']");
    public SelenideElement continueButton = $("button[type='submit']");
    public SelenideElement birthdayInput = $("[data-testid=\"birthdate-input\"]");
    public SelenideElement saveBirthdayButton = $("[data-testid=\"save-birthdate-button\"]");
    public SelenideElement searchIcon = $("button[aria-label='Search']");
    public SelenideElement searchInput = $("[data-testid='main-search-input']");
    public SelenideElement searchResult = $("[data-testid='product-card-title']");
    public SelenideElement wishlistButton = $("[data-testid=\"icon-whishlist-btn\"]");
    public SelenideElement productName = $(".boNuA-D");
}

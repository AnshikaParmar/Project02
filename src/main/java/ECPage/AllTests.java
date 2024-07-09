package ECPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllTests {
	 WebDriver driver;
	    HomePage homePage;
	    SignupPage signupPage;
	    AccountPage accountCreationPage;
	    LoginPage loginPage;
	    UseAccount userAccountPage;
	    ContactUs contactUsPage;
	    Product productPage; 
	    CartPage cartPage;
	    Checkout checkoutPage;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        homePage = new HomePage(driver);
	        signupPage = new SignupPage(driver);
	        accountCreationPage = new AccountPage(driver);
	        loginPage = new LoginPage(driver);
	        userAccountPage = new UseAccount(driver);
	        contactUsPage = new ContactUs(driver);
	        productPage = new Product("Sample Product", 99.99, "Sample description", "Electronics");
	        cartPage = new CartPage(driver);
	        checkoutPage = new Checkout(driver);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Set implicit wait
	    }

	    @Test(priority = 1)
	    public void registerUserTest() {
	        homePage.navigateToHomePage();
	        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

	        homePage.clickSignupLogin();
	        Assert.assertTrue(signupPage.isNewUserSignupVisible(), "New User Signup is not visible");

	        signupPage.enterNameAndEmail("Umesh Kumar", "Umesh201@gmail.com");
	        signupPage.clickSignupButton();

	        Assert.assertTrue(accountCreationPage.isEnterAccountInformationVisible(), "Enter Account Information is not visible");

	        accountCreationPage.fillAccountDetails("Mr", "Umesh Kumar", "Umesh201@gmail.com", "password123", "10", "May", "2001");
	        accountCreationPage.selectNewsletterCheckbox();
	        accountCreationPage.selectOffersCheckbox();
	        accountCreationPage.fillPersonalDetails("Umesh", "Kumar", "TeCompany", "123 Test St", "Apt 4", "India", "UP", "Bareilly", "12345", "1234567890");
	        accountCreationPage.clickCreateAccountButton();

	        Assert.assertTrue(accountCreationPage.isAccountCreatedVisible(), "Account Created is not visible");

	        accountCreationPage.clickContinueButton();
	        Assert.assertTrue(userAccountPage.isLoggedInAsVisible("Umesh Kumar"), "User is not logged in as Umesh Kumar");
	    }
    @Test(priority = 2)
    public void loginUserWithCorrectCredentials() {
        homePage.navigateToHomePage();
        homePage.clickSignupLogin();
        loginPage.loginUser("Umesh201@gmail.com", "password123");
        assert userAccountPage.isLoggedInAsVisible("Umesh Kumar");
    }

    @Test(priority = 3)
    public void loginUserWithIncorrectCredentials() {
        homePage.navigateToHomePage();
        homePage.clickSignupLogin();
        loginPage.loginUser("wronguser@example.com", "wrongpassword");
        assert !userAccountPage.isLoggedInAsVisible("wronguser");
    }

    @Test(priority = 4)
    public void logoutUserTest() {
        homePage.navigateToHomePage();
        userAccountPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginButtonVisible(), "Login button is not visible after logout");
    }

    @Test(priority = 5)
    public void registerUserWithExistingEmail() {
        homePage.navigateToHomePage();
        homePage.clickSignupLogin();
        signupPage.enterNameAndEmail("Umesh Kumar", "Umesh201@gmail.com");
        signupPage.clickSignupButton();
        assert signupPage.isEmailAlreadyExistVisible();
    }

    @Test(priority = 6)
    public void contactUsFormTest() {
        ContactUs contactUsPage = new ContactUs(driver);
        
        contactUsPage.fillContactForm("John Doe", "john.doe@example.com", "This is a test message.");
        contactUsPage.clickSubmit();
        
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed());
    }


    @Test(priority = 7)
    public void verifyTestCasesPageTest() {
        homePage.navigateToHomePage();
        homePage.clickTestCases();
    }

    @Test(priority = 8)
    public void verifyAllProductsAndProductDetailPageTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 9)
    public void searchProductTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 10)
    public void verifySubscriptionInHomePageTest() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");

        homePage.enterSubscriptionEmail("test@example.com");
        homePage.clickSubscribeButton();
        Assert.assertTrue(homePage.isSubscriptionSuccessMessageDisplayed(), "Subscription success message is not displayed");
    }

    @Test(priority = 11)
    public void verifySubscriptionInCartPageTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 12)
    public void addProductsInCartTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 13)
    public void verifyProductQuantityInCartTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 14)
    public void placeOrderRegisterWhileCheckoutTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 15)
    public void placeOrderRegisterBeforeCheckoutTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 16)
    public void placeOrderLoginBeforeCheckoutTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 17)
    public void removeProductsFromCartTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 18)
    public void viewCategoryProductsTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 19)
    public void viewAndCartBrandProductsTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 20)
    public void searchProductsAndVerifyCartAfterLoginTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 21)
    public void addReviewOnProductTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 22)
    public void addToCartFromRecommendedItemsTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 23)
    public void verifyAddressDetailsInCheckoutPageTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 24)
    public void downloadInvoiceAfterPurchaseOrderTest() {
        homePage.navigateToHomePage();
    }

    @Test(priority = 25)
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionalityTest() {
        homePage.navigateToHomePage();
     
    }

    @Test(priority = 26)
    public void verifyScrollUpWithoutArrowButtonAndScrollDownFunctionalityTest() {
        homePage.navigateToHomePage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

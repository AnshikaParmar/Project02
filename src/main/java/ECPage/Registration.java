package ECPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration {
    WebDriver driver;
    HomePage homePage;
    SignupPage signupPage;
    AccountPage accountCreationPage;
    LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
        accountCreationPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void registerUserTest() {
        homePage.navigateToHomePage();
        assert homePage.isHomePageVisible();

        homePage.clickSignupLogin();
        assert signupPage.isNewUserSignupVisible();

        signupPage.enterNameAndEmail("Umesh Kumar", "Umesh201@gmail.com");
        signupPage.clickSignupButton();

        assert accountCreationPage.isEnterAccountInformationVisible();

        accountCreationPage.fillAccountDetails("Mr", "Umesh Kumar", "Umesh201@gmail.com", "password123", "10", "May", "2001");
        accountCreationPage.selectNewsletterCheckbox();
        accountCreationPage.selectOffersCheckbox();
        accountCreationPage.fillPersonalDetails("Umesh", "Kumar", "TeCompany", "123 Test St", "Apt 4", 
                                                 "India", "UP", "Bareilly", "12345", "1234567890");
        accountCreationPage.clickCreateAccountButton();

        assert accountCreationPage.isAccountCreatedVisible();

        accountCreationPage.clickContinueButton();
        assert accountCreationPage.isLoggedInAsVisible("Umesh Kumar");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

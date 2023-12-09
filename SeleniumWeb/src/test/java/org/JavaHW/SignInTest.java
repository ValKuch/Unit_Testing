package org.JavaHW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SignInTest {

    @FindBy(css = "app-header:nth-child(1) .ubs-header-sing-in-img")
    private WebElement signInButton;

    @FindBy(xpath = ".//app-sign-in/h1")
    private WebElement welcomeText;

    @FindBy(css = ".title-text")
    private WebElement welcomeText2;

    @FindBy(xpath = ".//app-sign-in/h2")
    private WebElement signInDetailsText;

    @FindBy(css = ".subtitle-text")
    private WebElement signInDetailsText2;

    @FindBy(xpath = ".//input[@id=\"email\"]/preceding-sibling::label")
    private WebElement emailLabel;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = ".ubsStyle")
    private WebElement signInSubmitButton;

    @FindBy(css = ".alert-general-error")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"pass-err-msg\"]")
    private WebElement errorPassword;

    @FindBy(xpath = "//*[@id=\"email-err-msg\"]/app-error/div")
    private WebElement errorEmail;

    @FindBy(xpath = ".//button/child::span")
    private WebElement signInGoogle;

    @FindBy(xpath = "//*[@id=\"credentials-picker-container\"]")
    private WebElement popUpGoogle;

    @FindBy(xpath = ".//*[@class=\"forgot-password-ubs\"]")
    private WebElement forgotPassword;

    @FindBy(css = ".ubs-send-btn")
    private WebElement passResetButton;

    @FindBy(css = ".ubs-link")
    private WebElement signUpNoAccount;

    @FindBy(xpath = ".//*[@id=\"first-section\"]/child::h2")
    private WebElement insideAccount;



    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.greencity.social/");
        driver.manage().window().setSize(new Dimension(1264, 798));
    }

    @BeforeEach
    public void initPageElements() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("GreenCity", driver.getTitle());
    }
    

    @ParameterizedTest
    @CsvSource({
            "valerie.bucky69@gmail.com, Xxzi9swS9RkFRhx$",
            "anotheruser@greencity.com, anotherpassword"

    })
    public void signIn(String email, String password) {
        signInButton.click();
        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));
        emailInput.sendKeys(email);
        assertThat(emailInput.getAttribute("value"), is(email));
        passwordInput.sendKeys(password);
        assertThat(passwordInput.getAttribute("value"), is(password));
        signInSubmitButton.click();
        assertThat(insideAccount.getText(), is("How to prepare?"));

    }

    @ParameterizedTest
    @CsvSource({
            "samplestesgreencity.com",
    })
    public void signInNotValid(String email) {
        signInButton.click();
        emailInput.sendKeys(email);
        passwordInput.sendKeys("uT346^^^erw");
        assertThat(errorEmail.getText(), is("Please check if the email is written correctly"));
    }

    @ParameterizedTest
    @CsvSource({
            "Password must be at least 8 characters long without spaces"
    })
    public void passwordNotValid(String message) {
        signInButton.click();
        emailInput.sendKeys("samplestes@greencity.com");
        passwordInput.sendKeys(" ");
        signInSubmitButton.click();
        assertThat(errorPassword.getText(), is(message));

    }

    @ParameterizedTest
    @CsvSource({
            " , Password must be at least 8 characters long without spaces",
            "123456, Bad email or password"
    })
    public void passwordNotValid0(String password, String message) {
        signInButton.click();
        emailInput.sendKeys("samplestes@greencity.com");
        passwordInput.sendKeys(" ");
        signInSubmitButton.click();
        assertThat(errorPassword.getText(), is(message));

    }

    /*
    @Test
    public void signInWithGoogle() {
        signInButton.click();
        signInGoogle.click();
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        assertTrue(iframeElement.isDisplayed());

    }
    */

    @ParameterizedTest
    @CsvSource({
            "valerie.bucky69@gmail.com"
    })
    public void forgotPassword(String email) {
        signInButton.click();
        forgotPassword.click();
        emailInput.sendKeys(email);
        assertTrue(passResetButton.isDisplayed());

    }

    @Test
    public void signUpInstead() {
        signInButton.click();
        signUpNoAccount.click();
        assertThat(welcomeText2.getText(), is("Hello!"));
        assertThat(signInDetailsText2.getText(), is("Please enter your details to sign up."));
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

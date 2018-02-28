package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.quizfullTask.domen.Account;

public class RegistrationPage extends BasePage {

    private static final Logger LOG = LogManager.getRootLogger();

    private static final By INPUT_LOGIN = By.id("login");
    private static final By INPUT_PASSWORD = By.name("registrationForm.password");
    private static final By INPUT_REPASSWORD = By.name("registrationForm.repassword");
    private static final By INPUT_EMAIL = By.name("registrationForm.email");
    private static final By CHECKBOX_CORPORATE = By.id("corporate");
    private static final By INPUT_CAPTCHA = By.name("registrationForm.captcha");
    private static final By BUTTON_OK = By.name("ok");

    private WebElement inputLogin;
    private WebElement inputPassword;
    private WebElement inputRepassword;
    private WebElement inputEmail;
    private WebElement checkboxCorporate;
    private WebElement inputCaptcha;
    private WebElement buttonOk;

    public RegistrationPage(WebDriver driver) {
	super(driver);
	HomePage page = new HomePage(driver);
	page.openRegistrationPage();
	LOG.info("open: Registration page " + driver.getCurrentUrl());
    }

    public void createNewAcount(Account account) {
	inputLogin = driver.findElement(INPUT_LOGIN);
	inputLogin.sendKeys(account.getLogin());
	inputPassword = driver.findElement(INPUT_PASSWORD);
	inputPassword.sendKeys(account.getPassword());
	inputRepassword = driver.findElement(INPUT_REPASSWORD);
	inputRepassword.sendKeys(account.getRepassword());
	inputEmail = driver.findElement(INPUT_EMAIL);
	inputEmail.sendKeys(account.getEmail());
	if (account.isCorporate()) {
	    checkboxCorporate = driver.findElement(CHECKBOX_CORPORATE);
	    checkboxCorporate.click();
	}
	inputCaptcha = driver.findElement(INPUT_CAPTCHA);
	inputCaptcha.click();
	buttonOk = driver.findElement(BUTTON_OK);
	buttonOk.click();
    }
    
    //TODO vremeno
    public boolean isResult(){
	String res = "Неправильное число";
	WebElement divErrors = driver.findElement(By.xpath("//div[@class = 'errors']"));
	String result = divErrors.getText();
	return res.equals(result);
    }
}

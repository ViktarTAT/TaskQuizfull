package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import by.htp.quizfullTask.domen.Account;

public class RegistrationPage extends BasePage {
    
    private static final Logger LOG = LogManager.getRootLogger();

    @FindBy(id = "login")
    private WebElement inputLogin;

    @FindBy(name = "registrationForm.password")
    private WebElement inputPassword;

    @FindBy(name = "registrationForm.repassword")
    private WebElement inputRepassword;

    @FindBy(name = "registrationForm.email")
    private WebElement inputEmail;

    @FindBy(id = "corporate")
    private WebElement checkboxCorporate;

    @FindBy(name = "registrationForm.captcha")
    private WebElement inputCaptcha;

    @FindBy(name = "ok")
    private WebElement buttonOk;

    public RegistrationPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
	HomePage page = new HomePage(driver);
	page.openRegistrationPage();
	LOG.info("open: Registration page " + driver.getCurrentUrl());
    }

    public void createNewAcount(Account account) {
	inputLogin.sendKeys(account.getLogin());
	inputPassword.sendKeys(account.getPassword());
	inputRepassword.sendKeys(account.getRepassword());
	inputEmail.sendKeys(account.getEmail());
	if (account.isCorporate())
	    checkboxCorporate.click();
	inputCaptcha.click();
	buttonOk.click();
    }

}

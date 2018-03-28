package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private static final By DIV_ERRORS = By.xpath("//div[@class = 'errors']");

    public RegistrationPage(WebDriver driver) {
	super(driver);
	driver.get("http://www.quizful.net/LoginAction.registration");
	LOG.info("open: Registration page " + driver.getCurrentUrl());
    }

    public void createNewAcount(Account account) {
	driver.findElement(INPUT_LOGIN).sendKeys(account.getLogin());
	driver.findElement(INPUT_PASSWORD).sendKeys(account.getPassword());
	driver.findElement(INPUT_REPASSWORD).sendKeys(account.getRepassword());
	driver.findElement(INPUT_EMAIL).sendKeys(account.getEmail());
	if (account.isCorporate())
	    driver.findElement(CHECKBOX_CORPORATE).click();
	//driver.findElement(INPUT_CAPTCHA).click();
	driver.findElement(BUTTON_OK).click();
    }
    
    public String isReportError() {
    	String errorText = "";
    	if(driver.findElement(DIV_ERRORS).isDisplayed())
    		errorText = driver.findElement(DIV_ERRORS).getText();
    	return errorText;
    }

    // TODO vremeno
    public boolean isResult() {
	String res = "Неправильное число";
	WebElement divErrors = driver.findElement(DIV_ERRORS);
	String result = divErrors.getText();
	return res.equals(result);
    }
}

package by.htp.quizfullTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

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
    }

}

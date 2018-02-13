package by.htp.quizfullTask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String BASE_URL = "http://www.quizful.net";

    @FindBy(xpath = "//ul[@id='user-panel']/li[3]/a")
    private WebElement buttonRegistration;

    public HomePage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
	driver.get(BASE_URL);
    }

    public void openRegistrationPage() {
	buttonRegistration.click();
    }
    
}

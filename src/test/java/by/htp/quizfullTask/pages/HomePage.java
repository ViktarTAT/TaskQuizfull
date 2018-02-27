package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public static final String BASE_URL = "http://www.quizful.net";
    private static final Logger LOG = LogManager.getRootLogger();

    @FindBy(xpath = "//ul[@id='user-panel']/li[3]/a")
    private WebElement buttonRegistration;

    public HomePage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
	driver.get(BASE_URL);
	LOG.info("open: Home page " + driver.getCurrentUrl());
    }

    public void openRegistrationPage() {
	buttonRegistration.click();
    }
    
}

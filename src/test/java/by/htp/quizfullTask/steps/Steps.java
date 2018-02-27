package by.htp.quizfullTask.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.quizfullTask.domen.Account;
import by.htp.quizfullTask.driver.DriverFactory;
import by.htp.quizfullTask.pages.HomePage;
import by.htp.quizfullTask.pages.RegistrationPage;

public class Steps {
    private WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();

    public void startBrowser(String nameDriver) {
	logger.info("start: 'startBrowser'");
	driver = DriverFactory.createDriver(nameDriver);
	logger.info("finish: 'startBrowser'");
    }

    public void openHomePage() {
	HomePage page = new HomePage(driver);
	logger.info("open: Home page " + driver.getCurrentUrl());
    }
    
    public void openRegistrationPage() {
	RegistrationPage page = new RegistrationPage(driver);
	logger.info("open: Registration page " + driver.getCurrentUrl());
    }
    
    public void createNewAccount(Account account) {
	RegistrationPage page = new RegistrationPage(driver);
	page.createNewAcount(account);
    }

    public void closeBrowser() {
	DriverFactory.close();
    }
}

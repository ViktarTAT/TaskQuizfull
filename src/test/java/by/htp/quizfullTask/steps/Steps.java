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
    private static final Logger LOG = LogManager.getRootLogger();

    public void startBrowser(String nameDriver) {
	LOG.info("start: 'startBrowser'");
	driver = DriverFactory.getInstance(nameDriver);
	LOG.info("finish: 'startBrowser'");
    }

    public boolean createNewAccount(Account account) {
	RegistrationPage page = new RegistrationPage(driver);
	page.createNewAcount(account);
	return page.isResult();
    }
    
    
}

package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.quizfullTask.domen.Account;
import by.htp.quizfullTask.domen.AccountFactory;
import by.htp.quizfullTask.driver.DriverFactory;
import by.htp.quizfullTask.steps.Steps;

public class QuizfullTest {
    private Steps steps;
    Logger logger = LogManager.getRootLogger();

    @BeforeClass
    public void setUp() {
	logger.info("start: 'setUp'");
	steps = new Steps();
	steps.startBrowser("chrome");
	logger.info("finish: 'setUp'");
    }

    @Test
    public void oneCanCreateAccount() {
	logger.info("start: 'oneCanCreateAccount'");
	AccountFactory factory = new AccountFactory();
	Account account = factory.getAccount();
	logger.info(account);
	boolean result;
	result = steps.createNewAccount(account);
	logger.info("finish: 'oneCanCreateAccount'");
	Assert.assertTrue(result);
    }

    @AfterClass
    public void SetDown() {
	DriverFactory.close();
    }
}

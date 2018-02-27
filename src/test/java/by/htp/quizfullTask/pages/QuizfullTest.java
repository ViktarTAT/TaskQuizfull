package by.htp.quizfullTask.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.htp.quizfullTask.domen.Account;
import by.htp.quizfullTask.steps.Steps;

public class QuizfullTest {
    private Steps steps;
    Logger logger = LogManager.getRootLogger();

    @BeforeMethod
    public void setUp() {
	logger.info("start: 'setUp'");
	steps = new Steps();
	steps.startBrowser("chrome");
	logger.info("finish: 'setUp'");
    }

    @Test
    public void oneCanCreateAccount() {
	logger.info("start: 'oneCanCreateAccount'");
	Account account = new Account("asdf2", "1", "1", "asdf2@mail.ru", true); 
	logger.info(account);
	steps.createNewAccount(account);
	logger.info("finish: 'oneCanCreateAccount'");
    }
}

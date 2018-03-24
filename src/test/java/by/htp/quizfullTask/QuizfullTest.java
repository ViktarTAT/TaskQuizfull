package by.htp.quizfullTask;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import by.htp.quizfullTask.domen.Account;
import by.htp.quizfullTask.domen.AccountFactory;
import by.htp.quizfullTask.driver.DriverFactory;
import by.htp.quizfullTask.steps.Steps;

public class QuizfullTest {
    private Steps steps;
    private Logger LOG = LogManager.getRootLogger();
    private AccountFactory factory = new AccountFactory();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
	LOG.info("start: 'setUp'");
	steps = new Steps();
	steps.startBrowser("chrome");
	LOG.info("finish: 'setUp'");
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccount() {
	assertTrue(test("oneCanCreateAccount", factory.getAccount()));
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailWithSpace() {
	assertTrue(test("start: 'oneCanCreateAccountEmailWithSpace", 
		factory.getAccountEmailWithSpace()));
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailFirstSymbolSpace() {
	assertTrue(test("oneCanCreateAccountEmailFirstSymbolSpace", 
		factory.getAccountEmailFirstSymbolSpace()));
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMinSize() {
	assertTrue(test("oneCanCreateAccountLoginMinSize", 
		factory.getAccountLoginMinSize()));
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMaxSize() {
	assertTrue(test("oneCanCreateAccountLoginMaxSize", 
		factory.getAccountLoginMaxSize()));
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginFirstSymbolSpace() {
	assertTrue(test("oneCanCreateAccountLoginFirstSymbolSpace", 
		factory.getAccountLoginFirstSymbolSpace()));
    }

    @Test(groups = { "negative", "password" })
    public void oneCanCreateAccountWithautPass() {
    	LOG.info("start: " + "oneCanCreateAccountWithautPass");
    	Account account = factory.getAccountWithoutPass();
    	LOG.info(account);
    	String result = steps.createNewAccountWithError(account);
    	LOG.info("error: " + result);
    	LOG.info("finish: " + "oneCanCreateAccountWithautPass");
	assertEquals(result, "Введите пароль/n Пароли не совпадают/n Неправильное число");
    }

    @Test(groups = { "negative", "password1" })
    public void oneCanCreateAccountWithautRepass() {
	assertTrue(test("oneCanCreateAccountWithautRepass", 
		factory.getAccountWithoutRepass()));
    }

    private boolean test(String text, Account account) {
	LOG.info("start: " + text);
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: " + text);
	return result;
    }

    @AfterClass(alwaysRun = true)
    public void SetDown() {
	DriverFactory.close();
    }
}

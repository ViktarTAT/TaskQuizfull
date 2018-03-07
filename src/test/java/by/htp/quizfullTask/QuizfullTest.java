package by.htp.quizfullTask;

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
	test("oneCanCreateAccount", factory.getAccount());
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailWithSpace() {
	test("start: 'oneCanCreateAccountEmailWithSpace", 
		factory.getAccountEmailWithSpace());
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailFirstSymbolSpace() {
	test("oneCanCreateAccountEmailFirstSymbolSpace", 
		factory.getAccountEmailFirstSymbolSpace());
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMinSize() {
	test("oneCanCreateAccountLoginMinSize", 
		factory.getAccountLoginMinSize());
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMaxSize() {
	test("oneCanCreateAccountLoginMaxSize", 
		factory.getAccountLoginMaxSize());
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginFirstSymbolSpace() {
	test("oneCanCreateAccountLoginFirstSymbolSpace", 
		factory.getAccountLoginFirstSymbolSpace());
    }

    @Test(groups = { "negative", "password" })
    public void oneCanCreateAccountWithautPass() {
	test("oneCanCreateAccountWithautPass", 
		factory.getAccountWithoutPass());
    }

    @Test(groups = { "negative", "password" })
    public void oneCanCreateAccountWithautRepass() {
	test("oneCanCreateAccountWithautRepass", 
		factory.getAccountWithoutRepass());
    }

    private void test(String text, Account account) {
	LOG.info("start: " + text);
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: " + text);
	assertTrue(result);
    }

    @AfterClass(alwaysRun = true)
    public void SetDown() {
	DriverFactory.close();
    }
}

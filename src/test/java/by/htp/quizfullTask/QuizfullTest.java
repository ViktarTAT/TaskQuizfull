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
	LOG.info("start: 'oneCanCreateAccount'");
	Account account = factory.getAccount();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccount'");
	assertTrue(result);
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailWithSpace() {
	LOG.info("start: 'oneCanCreateAccountEmailWithSpace'");
	Account account = factory.getAccountEmailWithSpace();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountEmailWithSpace'");
	assertTrue(result);
    }

    @Test(groups = { "positive", "email" })
    public void oneCanCreateAccountEmailFirstSymbolSpace() {
	LOG.info("start: 'oneCanCreateAccountEmailFirstSymbolSpace'");
	Account account = factory.getAccountEmailFirstSymbolSpace();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountEmailFirstSymbolSpace'");
	assertTrue(result);
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMinSize() {
	LOG.info("start: 'oneCanCreateAccountLoginMinSize'");
	Account account = factory.getAccountLoginMinSize();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountLoginMinSize'");
	assertTrue(result);
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginMaxSize() {
	LOG.info("start: 'oneCanCreateAccountLoginMaxSize'");
	Account account = factory.getAccountLoginMaxSize();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountLoginMaxSize'");
	assertTrue(result);
    }

    @Test(groups = { "positive", "login" })
    public void oneCanCreateAccountLoginFirstSymbolSpace() {
	LOG.info("start: 'oneCanCreateAccountLoginFirstSymbolSpace'");
	Account account = factory.getAccountLoginFirstSymbolSpace();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountLoginFirstSymbolSpace'");
	assertTrue(result);
    }

    @Test(groups = { "negative", "password" })
    public void oneCanCreateAccountWithautPass() {
	LOG.info("start: 'oneCanCreateAccountLoginFirstSymbolSpace'");
	Account account = factory.getAccountLoginFirstSymbolSpace();
	LOG.info(account);
	boolean result = steps.createNewAccount(account);
	LOG.info("finish: 'oneCanCreateAccountLoginFirstSymbolSpace'");
	assertTrue(result);
    }

    @Test(groups = { "test" })
    public void testTESTtest() {
	test("testTESTtest", factory.getAccountLoginMaxSize());
    }
    
    @Test(groups = { "test" })
    public void testTESTtest2() {
	test("testTESTtest2", factory.getAccountLoginMoreMaxSize());
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

package by.htp.quizfullTask;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import by.htp.quizfullTask.domen.Account;
import by.htp.quizfullTask.domen.AccountFactory;
import by.htp.quizfullTask.driver.DriverFactory;
import by.htp.quizfullTask.steps.Steps;

public class QuizfullTest {
	private Steps steps;
	private Logger LOG = LogManager.getRootLogger();
	private AccountFactory factory = new AccountFactory();

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setUp(String browser) {
		LOG.info("start: 'setUp'");
		steps = new Steps();
		steps.startBrowser(browser);
		LOG.info("finish: 'setUp'");
	}

	@Test(groups = { "positive", "email1" })
	public void oneCanCreateAccount() {
		assertTrue(test("oneCanCreateAccount", factory.getAccount()));
	}

	@Test(groups = { "positive", "email" })
	public void oneCanCreateAccountEmailWithSpace() {
		assertTrue(test("start: 'oneCanCreateAccountEmailWithSpace",
				factory.getAccountEmailLastSymbolSpace()));
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

	private boolean test(String text, Account account) {
		LOG.info("start: " + text);
		LOG.info(account);
		boolean result = steps.createNewAccount(account);
		LOG.info("finish: " + text);
		return result;
	}

	@Test(groups = { "negative", "password" })
	public void oneCanCreateAccountWithautPass() {
		String result = testError("oneCanCreateAccountWithautPass",
				factory.getAccountWithoutPass());
		assertEquals(result, "Введите пароль\n" + "Пароли не совпадают\n"
				+ "Неправильное число");
	}

	@Test(groups = { "negative", "password" })
	public void oneCanCreateAccountWithautRepass() {
		String result = testError("oneCanCreateAccountWithautRepass",
				factory.getAccountWithoutRepass());
		assertEquals(result, "Пароли не совпадают\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginIsLessMinSize() {
		String result = testError("oneCanCreateAccountLoginIsLessMinSize",
				factory.getAccountLoginIsLessMinSize());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginIsMoreMaxSize() {
		String result = testError("oneCanCreateAccountLoginIsLessMinSize",
				factory.getAccountLoginIsMoreMaxSize());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginWithoutLatinLetters() {
		String result = testError("oneCanCreateAccountLoginWithoutLatinLetters",
				factory.getAccountLoginWithoutLatinLetters());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginWithNoLatinLetters() {
		String result = testError("oneCanCreateAccountLoginWithNoLatinLetters",
				factory.getAccountLoginWithNoLatinLetters());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginFirstSymbolIsNumber() {
		String result = testError("oneCanCreateAccountLoginFirstSymbolIsNumber",
				factory.getAccountLoginFirstSymbolIsNumber());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	@Test(groups = { "negative", "login" })
	public void oneCanCreateAccountLoginFirstSymbolIsUnderscore() {
		String result = testError(
				"oneCanCreateAccountLoginFirstSymbolIsUnderscore",
				factory.getAccountLoginFirstSymbolIsUnderscore());
		assertEquals(result,
				"Введен недопустимый логин\n" + "Неправильное число");
	}

	private String testError(String text, Account account) {
		LOG.info("start: " + text);
		LOG.info(account);
		String result = steps.createNewAccountWithError(account);
		LOG.info("finish: " + text);
		return result;
	}

	@AfterClass(alwaysRun = true)
	public void SetDown() {
		DriverFactory.close();
	}
}

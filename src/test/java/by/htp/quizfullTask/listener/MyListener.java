package by.htp.quizfullTask.listener;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import com.google.common.io.Files;

public class MyListener extends AbstractWebDriverEventListener {
	private Logger LOG = LogManager.getRootLogger();
	

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		LOG.info(by);
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		LOG.info("found " + by);
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		LOG.error(throwable);
		File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File screen = new File("screen-" + System.currentTimeMillis() + ".png");
		try {
			Files.copy(tmp, screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOG.info(screen);
	}
}

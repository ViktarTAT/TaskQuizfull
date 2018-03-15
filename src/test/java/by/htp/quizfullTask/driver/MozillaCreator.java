package by.htp.quizfullTask.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaCreator implements WebDriverCreator {

    @Override
    public WebDriver createDriver() {
	return new FirefoxDriver();
    }

}

package by.htp.quizfullTask.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IECreator implements WebDriverCreator {

    @Override
    public WebDriver createDriver() {
	return new InternetExplorerDriver();
    }

}

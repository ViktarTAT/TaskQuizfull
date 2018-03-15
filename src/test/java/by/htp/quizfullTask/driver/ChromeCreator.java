package by.htp.quizfullTask.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeCreator implements WebDriverCreator {

    @Override
    public WebDriver createDriver() {
	return new ChromeDriver();
    }

}

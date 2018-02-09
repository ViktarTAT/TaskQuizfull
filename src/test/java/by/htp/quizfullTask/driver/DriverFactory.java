package by.htp.quizfullTask.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver createDriver(String nameDriverString) {
	WebDriver driver = null;
	WebDriverCreator creator;
	ListNameDriver nameDriver;
	nameDriver = ListNameDriver.getNameDriver(nameDriverString);

	switch (nameDriver) {
	case CHROME:
	    driver = new ChromeCreator().createDriver();
	    break;
	}

	return driver;
    }
}

package by.htp.quizfullTask.driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver createDriver(String nameDriverString) {
	WebDriver driver = null;
	WebDriverCreator creator = null;
	ListNameDriver nameDriver;
	nameDriver = ListNameDriver.getNameDriver(nameDriverString);

	switch (nameDriver) {
	case CHROME:
	    creator = new ChromeCreator();
	    break;
	}
	
	driver = creator.createDriver();

	return driver;
    }
}

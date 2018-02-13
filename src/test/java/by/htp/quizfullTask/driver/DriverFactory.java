package by.htp.quizfullTask.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    
    //TODO singleTon
    private static WebDriver driver;
    private static final Logger logger = LogManager.getRootLogger();

    public static WebDriver createDriver(String nameDriverString) {
	logger.info("start: 'createDriver'");
	WebDriverCreator creator = null;
	ListNameDriver nameDriver;
	nameDriver = ListNameDriver.getNameDriver(nameDriverString);

	switch (nameDriver) {
	case CHROME:
	    creator = new ChromeCreator();
	    logger.info("creator: 'ChromeCreator'");
	    break;
	}

	driver = creator.createDriver();
	initBrowser();
	logger.info("finish: 'createDriver'");
	return driver;
    }
    
    public static void close() {
	driver.close();
	driver = null;
    }

    private static void initBrowser() {
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    }
}

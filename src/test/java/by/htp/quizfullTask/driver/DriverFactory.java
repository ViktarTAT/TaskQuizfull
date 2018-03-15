package by.htp.quizfullTask.driver;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver;
    private static final Logger LOG = LogManager.getRootLogger();

    public static WebDriver getInstance(String nameDriverString) {
	if (driver == null)
	    createDriver(nameDriverString);
	return driver;
    }

    public static void createDriver(String nameDriverString) {
	LOG.info("start: 'createDriver'");
	WebDriverCreator creator = null;
	NameDriver nameDriver;
	nameDriver = NameDriver.getNameDriver(nameDriverString);

	switch (nameDriver) {
	case CHROME:
	    creator = new ChromeCreator();
	    LOG.info("creator: 'ChromeCreator'");
	    break;
	case MOZILLA: 
	    creator = new MozillaCreator();
	    LOG.info("creator: 'MozillaCreator'");
	    break;
	case IEXPLORER:
	    creator = new IECreator();
	    LOG.info("creator: 'IECreator'");
	    break;
	}

	driver = creator.createDriver();
	initBrowser();
	LOG.info("finish: 'createDriver'");
    }

    public static void close() {
	driver.quit();
	driver = null;
    }

    private static void initBrowser() {
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
    }
}

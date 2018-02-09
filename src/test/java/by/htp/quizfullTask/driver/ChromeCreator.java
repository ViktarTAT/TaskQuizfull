package by.htp.quizfullTask.driver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeCreator implements WebDriverCreator {
    
    public static final String PATH_TO_DRIVER = "resources/chromedriver.exe";

    @Override
    public WebDriver createDriver() {
	WebDriver driver;
	ChromeDriverService service = new ChromeDriverService.Builder()
		.usingDriverExecutable(new File(PATH_TO_DRIVER)).build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
	driver = new ChromeDriver(service);
	return driver;
    }

}

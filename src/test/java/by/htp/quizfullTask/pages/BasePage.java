package by.htp.quizfullTask.pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public abstract class BasePage {

    protected EventFiringWebDriver driver;
    
    public BasePage(EventFiringWebDriver driver){
	this.driver = driver;
    }
    
    
}

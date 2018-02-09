package by.htp.quizfullTask.driver;

public enum ListNameDriver {
    CHROME;
    
    public static ListNameDriver getNameDriver(String nameDriver) {
	return ListNameDriver.valueOf(nameDriver.toUpperCase());
    }
}

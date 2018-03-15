package by.htp.quizfullTask.driver;

public enum NameDriver {
    CHROME, MOZILLA, IEXPLORER;
    
    public static NameDriver getNameDriver(String nameDriver) {
	nameDriver = nameDriver.toUpperCase();
	return NameDriver.valueOf(nameDriver);
    }
}

package utils.framework;

public enum Browser {

    CHROME("chrome"),
    FIREFOX("firefox");

    private final String browser;

    Browser(String browser){
        this.browser = browser;
    }

    public String getBrowser(){
        return browser;
    }
}
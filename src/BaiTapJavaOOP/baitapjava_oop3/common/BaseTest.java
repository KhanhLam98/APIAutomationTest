package baitapjava_oop3.common;



public class BaseTest extends Constants{

    public void createDriver(){
        System.out.println("Browser: " + browser);
        System.out.println("Report: " + report);
        System.out.println("Headless: " + headless);
    }

    public void closeDriver() {
        System.out.println("Closed browser: " + browser);
    }
}
